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
package org.linqs.psl.model.rule.logical;

import org.linqs.psl.model.atom.GroundAtom;
import org.linqs.psl.model.formula.Disjunction;
import org.linqs.psl.model.formula.Formula;
import org.linqs.psl.model.formula.Negation;
import org.linqs.psl.model.rule.GroundRule;
import org.linqs.psl.reasoner.function.GeneralFunction;
import org.linqs.psl.util.HashCode;
import org.linqs.psl.util.IteratorUtils;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Base class for all ground logical rules.
 */
public abstract class AbstractGroundLogicalRule implements GroundRule {
	protected final AbstractLogicalRule rule;
	protected final List<GroundAtom> posLiterals;
	protected final List<GroundAtom> negLiterals;
	protected final GeneralFunction function;

	private final int hashcode;

	/**
	 * @param rvaCount the number of RandomVariableAtoms (non-constants) in the literals.
	 */
	protected AbstractGroundLogicalRule(AbstractLogicalRule rule, List<GroundAtom> posLiterals, List<GroundAtom> negLiterals, int rvaCount) {
		this.rule = rule;
		this.posLiterals = Collections.unmodifiableList(new ArrayList<GroundAtom>(posLiterals));
		this.negLiterals = Collections.unmodifiableList(new ArrayList<GroundAtom>(negLiterals));

		// Construct the hash code.
		int hash = HashCode.build(rule);

		// Construct function definition.
		boolean nonNegative = (posLiterals.size() + negLiterals.size() > 1);
		function = new GeneralFunction(nonNegative, false, rvaCount);

		for (int i = 0; i < posLiterals.size(); i++) {
			function.add(1.0, posLiterals.get(i).getVariable());
			hash = HashCode.build(hash, posLiterals.get(i));
		}

		for (int i = 0; i < negLiterals.size(); i++) {
			function.add(-1.0, negLiterals.get(i).getVariable());
			hash = HashCode.build(hash, negLiterals.get(i));
		}

		function.add(1.0 - posLiterals.size());
		hashcode = hash;
	}

	protected GeneralFunction getFunction() {
		return function;
	}

	@Override
	public Set<GroundAtom> getAtoms() {
		HashSet<GroundAtom> atoms = new HashSet<GroundAtom>();

		for (GroundAtom atom : posLiterals) {
			atoms.add(atom);
		}

		for (GroundAtom atom : negLiterals) {
			atoms.add(atom);
		}

		return atoms;
	}

	public List<GroundAtom> getPositiveAtoms() {
		return posLiterals;
	}

	public List<GroundAtom> getNegativeAtoms() {
		return negLiterals;
	}

	public int size() {
		return posLiterals.size() + negLiterals.size();
	}

	/**
	 * Negating logical rules (a disjunction) will generate multiple other rules.
	 * !(A v B) = A! ^ !B
	 * The conjunction will incur the same penalty as these disjunctions: [!A v !B, A v !B, !A v B].
	 * We this will generate 2^n - 1 ground rules where n is the number of atoms in the rule.
	 */
	@Override
	public List<GroundRule> negate() {
		int numAtoms = size();
		List<GroundRule> negatedRules = new ArrayList<GroundRule>((int)Math.pow(2, numAtoms) - 1);

		List<GroundAtom> positiveAtoms = new ArrayList<GroundAtom>(numAtoms);
		List<GroundAtom> negativeAtoms = new ArrayList<GroundAtom>(numAtoms);
		Formula[] disjunction = new Formula[numAtoms];

		// To generate the correct ground rules, we just need to take all the atoms and
		// do a power set over them, where membership in the set means negation
		// (but remember that we may be negating a negation).
		// The all negation case (full set membership) is ignored.
		for (boolean[] subset : IteratorUtils.powerset(numAtoms)) {
			// Skip when all atoms are negated.
			// Unless there is only one atom, then do the opposite and skip the positive case.
			boolean skip = true;

			if (numAtoms == 1) {
				skip = !subset[0];
			} else {
				for (boolean negated : subset) {
					if (!negated) {
						skip = false;
						break;
					}
				}
			}

			if (skip) {
				continue;
			}

			String name = String.format("%s -- Negated (%s)", rule.getName(), Arrays.toString(subset));

			positiveAtoms.clear();
			negativeAtoms.clear();

			int subsetIndex = 0;

			for (GroundAtom atom : posLiterals) {
				if (subset[subsetIndex]) {
					negativeAtoms.add(atom);
					disjunction[subsetIndex] = new Negation(atom);
				} else {
					positiveAtoms.add(atom);
					disjunction[subsetIndex] = atom;
				}

				subsetIndex++;
			}

			for (GroundAtom atom : negLiterals) {
				if (subset[subsetIndex]) {
					positiveAtoms.add(atom);
					disjunction[subsetIndex] = atom;
				} else {
					negativeAtoms.add(atom);
					disjunction[subsetIndex] = new Negation(atom);
				}

				subsetIndex++;
			}

			Formula formula = null;
			if (disjunction.length > 1) {
				formula = new Disjunction(disjunction);
			} else {
				formula = disjunction[0];
			}

			negatedRules.add(instantiateNegatedGroundRule(formula, positiveAtoms, negativeAtoms, name));
		}

		return negatedRules;
	}

	protected abstract GroundRule instantiateNegatedGroundRule(
			Formula disjunction, List<GroundAtom> positiveAtoms,
			List<GroundAtom> negativeAtoms, String name);

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (other == null
				|| !(other instanceof AbstractGroundLogicalRule)
				|| this.hashCode() != other.hashCode()) {
			return false;
		}

		AbstractGroundLogicalRule otherRule = (AbstractGroundLogicalRule)other;
		if (!rule.equals(otherRule.getRule())) {
			return false;
		}

		return posLiterals.equals(otherRule.posLiterals)
				&& negLiterals.equals(otherRule.negLiterals);
	}

	@Override
	public int hashCode() {
		return hashcode;
	}

	@Override
	public String toString() {
		/* Negates the clause again to show clause to maximize truth of */
		Formula[] literals = new Formula[posLiterals.size() + negLiterals.size()];
		int i;

		for (i = 0; i < posLiterals.size(); i++) {
			literals[i] = new Negation(posLiterals.get(i));
		}

		for (int j = 0; j < negLiterals.size(); j++) {
			literals[i++] = negLiterals.get(j);
		}

		return (literals.length > 1) ? new Disjunction(literals).toString() : literals[0].toString();
	}
}
