/*
 * This file is part of the PSL software.
 * Copyright 2011-2015 University of Maryland
 * Copyright 2013-2018 The Regents of the University of California
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.linqs.psl.reasoner.dcd.term;

import org.linqs.psl.application.groundrulestore.GroundRuleStore;
import org.linqs.psl.config.Config;
import org.linqs.psl.model.rule.GroundRule;
import org.linqs.psl.model.rule.UnweightedGroundRule;
import org.linqs.psl.model.rule.WeightedGroundRule;
import org.linqs.psl.model.rule.WeightedRule;
import org.linqs.psl.reasoner.dcd.DCDReasoner;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.function.FunctionTerm;
import org.linqs.psl.reasoner.function.GeneralFunction;
import org.linqs.psl.reasoner.term.TermGenerator;
import org.linqs.psl.reasoner.term.TermStore;
import org.linqs.psl.util.MathUtils;
import org.linqs.psl.util.Parallel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A TermGenerator for ADMM objective terms.
 */
public class DCDTermGenerator implements TermGenerator<DCDObjectiveTerm> {
	private static final Logger log = LoggerFactory.getLogger(DCDTermGenerator.class);

	public static final String CONFIG_PREFIX = "dcdtermgenerator";

	/**
	 * If true, then invert negative weight rules into their positive weight counterparts
	 * (negate the weight and expression).
	 */
	public static final String INVERT_NEGATIVE_WEIGHTS_KEY = CONFIG_PREFIX + ".invertnegativeweights";
	public static final boolean INVERT_NEGATIVE_WEIGHTS_DEFAULT = false;

	private boolean invertNegativeWeight;
	private float c;

	public DCDTermGenerator() {
		invertNegativeWeight = Config.getBoolean(INVERT_NEGATIVE_WEIGHTS_KEY, INVERT_NEGATIVE_WEIGHTS_DEFAULT);
		c = Config.getFloat(DCDReasoner.C, DCDReasoner.C_DEFAULT);
	}

	@Override
	public int generateTerms(GroundRuleStore ruleStore, final TermStore<DCDObjectiveTerm> termStore) {
		if (!(termStore instanceof DCDTermStore)) {
			throw new IllegalArgumentException("DCDTermGenerator requires an DCDTermStore");
		}

		int initialSize = termStore.size();
		termStore.ensureCapacity(initialSize + ruleStore.size());

		Set<WeightedRule> rules = new HashSet<WeightedRule>();
		for (GroundRule rule : ruleStore.getGroundRules()) {
			if (rule instanceof WeightedGroundRule) {
				rules.add((WeightedRule)rule.getRule());
			}
		}

		for (WeightedRule rule : rules) {
			if (rule.getWeight() < 0.0) {
				log.warn("Found a rule with a negative weight, but config says not to invert it... skipping: " + rule);
			}
		}

		Parallel.foreach(ruleStore.getGroundRules(), new Parallel.Worker<GroundRule>() {
			@Override
			public void work(int index, GroundRule rule) {
				boolean negativeWeight =
						rule instanceof WeightedGroundRule
						&& ((WeightedGroundRule)rule).getWeight() < 0.0;

				if (negativeWeight) {
					// Skip
					if (!invertNegativeWeight) {
						return;
					}

					// Negate (weight and expression) rules that have a negative weight.
					for (GroundRule negatedRule : rule.negate()) {
						DCDObjectiveTerm term = createTerm(negatedRule, (DCDTermStore)termStore);
						if (term != null && term.variables.size() > 0) {
							termStore.add(rule, term);
						}
					}
				} else {
					DCDObjectiveTerm term = createTerm(rule, (DCDTermStore)termStore);
					if (term != null && term.variables.size() > 0) {
						termStore.add(rule, term);
					}
				}
			}
		});

		return termStore.size() - initialSize;
	}

	@Override
	public void updateWeights(GroundRuleStore ruleStore, TermStore<DCDObjectiveTerm> termStore) {
		// TODO(eriq): This is broken for when a rule switches sign.
		for (GroundRule groundRule : ruleStore.getGroundRules()) {
			if (groundRule instanceof WeightedGroundRule) {
				termStore.updateWeight((WeightedGroundRule)groundRule);
			}
		}
	}

	/**
	 * Processes a {@link GroundRule} to create a corresponding {@link DCDObjectiveTerm}.
	 *
	 * @param groundRule  the GroundRule to be added to the ADMM objective
	 * @return the created DCDObjectiveTerm or null if the term is trivial.
	 */
	private DCDObjectiveTerm createTerm(GroundRule groundRule, DCDTermStore termStore) {
		DCDObjectiveTerm term;

		if (groundRule instanceof WeightedGroundRule) {
			float weight = (float)((WeightedGroundRule)groundRule).getWeight();
			GeneralFunction function = ((WeightedGroundRule)groundRule).getFunctionDefinition();
			Hyperplane hyperplane = processHyperplane(function, termStore);
			if (hyperplane == null) {
				return null;
			}

			// Non-negative functions have a hinge.
			if (function.isNonNegative() && function.isSquared()) {
				term = new SquaredHingeLossTerm(hyperplane.variables, hyperplane.coeffs, hyperplane.constant, weight, c);
			} else if (function.isNonNegative() && !function.isSquared()) {
				term = new HingeLossTerm(hyperplane.variables, hyperplane.coeffs, hyperplane.constant, weight, c);
			} else if (!function.isNonNegative() && function.isSquared()) {
				throw new UnsupportedOperationException("DCD does not support squared linear terms: " + groundRule);
				//term = new SquaredLinearLossTerm(hyperplane.variables, hyperplane.coeffs, 0.0f, weight);
			} else {
				throw new UnsupportedOperationException("DCD does not support linear terms." + groundRule);
				//term = new LinearLossTerm(hyperplane.variables, hyperplane.coeffs, weight);
			}
		} else if (groundRule instanceof UnweightedGroundRule) {
			throw new UnsupportedOperationException("DCD does not support hard constraints." + groundRule);
		} else {
			throw new IllegalArgumentException("Unsupported ground rule: " + groundRule);
		}

		return term;
	}

	/**
	 * Construct a hyperplane from a general function.
	 * Will return null if the term is trivial and should be abandoned.
	 */
	private Hyperplane processHyperplane(GeneralFunction sum, DCDTermStore termStore) {
		Hyperplane hyperplane = new Hyperplane();
		hyperplane.constant = -1.0f * (float)sum.getConstant();

		for (int i = 0; i < sum.size(); i++) {
			float coefficient = (float)sum.getCoefficient(i);
			FunctionTerm term = sum.getTerm(i);

			if (term instanceof AtomFunctionVariable && !term.isConstant()) {
				termStore.registerVariable((AtomFunctionVariable)term);
				AtomFunctionVariable variable = (AtomFunctionVariable)term;
				// Check to see if we have seen this variable before in this hyperplane.
				// Note that we are checking for existence in a List (O(n)), but there are usually a small number of
				// variables per hyperplane.
				int localIndex = hyperplane.variables.indexOf(variable);
				if (localIndex != -1) {
					// If the local variable already exists, just add to its coefficient.
					float currentCoefficient = hyperplane.coeffs.get(localIndex).floatValue();

					// If this function came from a logical rule
					// and the sign of the current coefficient and the coefficient of this variable do not match,
					// this this term is trivial.
					// Recall that all logical rules are disjunctions with only +1 and -1 as coefficients.
					// A mismatch in signs for the same variable means that a ground atom appeared twice,
					// once as a positive atom and once as a negative atom: Foo('a') || !Foo('a').
					if (sum.isNonNegative() && !MathUtils.signsMatch(currentCoefficient, coefficient)) {
						return null;
					}

					hyperplane.coeffs.set(localIndex, new Float(hyperplane.coeffs.get(localIndex) + coefficient));
				} else {
					hyperplane.variables.add(variable);
					hyperplane.coeffs.add(new Float(coefficient));
				}
			} else if (term.isConstant()) {
				// Subtracts because hyperplane is stored as coeffs^T * x = constant.
				hyperplane.constant -= (coefficient * term.getValue());
			} else {
				throw new IllegalArgumentException("Unexpected summand: " + sum + "[" + i + "] (" + term + ").");
			}
		}

		return hyperplane;
	}

	private static class Hyperplane {
		public List<AtomFunctionVariable> variables;
		public List<Float> coeffs;
		public float constant;

		public Hyperplane() {
			variables = new ArrayList<AtomFunctionVariable>();
			coeffs = new ArrayList<Float>();
			constant = 0.0f;
		}
	}
}
