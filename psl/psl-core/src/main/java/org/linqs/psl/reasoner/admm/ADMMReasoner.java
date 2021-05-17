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
package org.linqs.psl.reasoner.admm;

import org.linqs.psl.config.Config;
import org.linqs.psl.model.rule.GroundRule;
import org.linqs.psl.model.rule.WeightedGroundRule;
import org.linqs.psl.reasoner.Reasoner;
import org.linqs.psl.reasoner.admm.term.*;
import org.linqs.psl.reasoner.term.TermStore;
import org.linqs.psl.util.MathUtils;
import org.linqs.psl.util.Parallel;
import org.linqs.psl.util.RandUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Uses an ADMM optimization method to optimize its GroundRules.
 */
public class ADMMReasoner implements Reasoner {
	private static final Logger log = LoggerFactory.getLogger(ADMMReasoner.class);

	/**
	 * Prefix of property keys used by this class.
	 */
	public static final String CONFIG_PREFIX = "admmreasoner";

	/**
	 * The maximum number of iterations of ADMM to perform in a round of inference.
	 */
	public static final String MAX_ITER_KEY = CONFIG_PREFIX + ".maxiterations";
	public static final int MAX_ITER_DEFAULT = 25000;

	/**
	 * Step size.
	 * Higher values result in larger steps.
	 * Should be positive.
	 */
	public static final String STEP_SIZE_KEY = CONFIG_PREFIX + ".stepsize";
	public static final float STEP_SIZE_DEFAULT = 1.0f;

	/**
	 * Absolute error component of stopping criteria.
	 * Should be positive.
	 */
	public static final String EPSILON_ABS_KEY = CONFIG_PREFIX + ".epsilonabs";
	public static final float EPSILON_ABS_DEFAULT = 1e-5f;

	/**
	 * Relative error component of stopping criteria.
	 * Should be positive.
	 */
	public static final String EPSILON_REL_KEY = CONFIG_PREFIX + ".epsilonrel";
	public static final float EPSILON_REL_DEFAULT = 1e-3f;

	/**
	 * Stop if the objective has not changed since the last logging period (see LOG_PERIOD).
	 */
	public static final String OBJECTIVE_BREAK_KEY = CONFIG_PREFIX + ".objectivebreak";
	public static final boolean OBJECTIVE_BREAK_DEFAULT = true;

	public static final String PRINT_OBJ = CONFIG_PREFIX + ".printobj";
	public static final boolean PRINT_OBJ_DEFAULT = true;

	/**
	 * Possible starting values for the consensus values.
	 *  - ZERO - 0.
	 *  - RANDOM - Uniform sample in [0, 1].
	 *  - ATOM - The value of the RVA that backs this global variable.
	 */
	public static enum InitialValue { ZERO, RANDOM, ATOM }

	/**
	 * The starting value for consensus variables.
	 * Values should come from the InitialValue enum.
	 */
	public static final String INITIAL_CONSENSUS_VALUE_KEY = CONFIG_PREFIX + ".initialconsensusvalue";
	public static final String INITIAL_CONSENSUS_VALUE_DEFAULT = InitialValue.RANDOM.toString();

	/**
	 * The starting value for local variables.
	 * Values should come from the InitialValue enum.
	 */
	public static final String INITIAL_LOCAL_VALUE_KEY = CONFIG_PREFIX + ".initiallocalvalue";
	public static final String INITIAL_LOCAL_VALUE_DEFAULT = InitialValue.RANDOM.toString();

	private static final float LOWER_BOUND = 0.0f;
	private static final float UPPER_BOUND = 1.0f;

	/**
	 * Log the residuals once in every period.
	 */
	private static final int LOG_PERIOD = 50;

	/**
	 * Sometimes called eta or rho,
	 */
	private final float stepSize;

	private float epsilonRel;
	private float epsilonAbs;

	private float primalRes;
	private float epsilonPrimal;
	private float dualRes;
	private float epsilonDual;

	private float AxNorm;
	private float AyNorm;
	private float BzNorm;
	private float lagrangePenalty;
	private float augmentedLagrangePenalty;

	private int maxIter;
	private boolean printObj;
	// Also sometimes called 'z'.
	// Only populated after inference.
	private float[] consensusValues;

	private int termBlockSize;
	private int variableBlockSize;
	private boolean objectiveBreak;

	public ADMMReasoner() {
		maxIter = Config.getInt(MAX_ITER_KEY, MAX_ITER_DEFAULT);
		stepSize = Config.getFloat(STEP_SIZE_KEY, STEP_SIZE_DEFAULT);
		objectiveBreak = Config.getBoolean(OBJECTIVE_BREAK_KEY, OBJECTIVE_BREAK_DEFAULT);
		printObj = Config.getBoolean(PRINT_OBJ, PRINT_OBJ_DEFAULT);

		epsilonAbs = Config.getFloat(EPSILON_ABS_KEY, EPSILON_ABS_DEFAULT);
		if (epsilonAbs <= 0) {
			throw new IllegalArgumentException("Property " + EPSILON_ABS_KEY + " must be positive.");
		}

		epsilonRel = Config.getFloat(EPSILON_REL_KEY, EPSILON_REL_DEFAULT);
		if (epsilonRel <= 0) {
			throw new IllegalArgumentException("Property " + EPSILON_REL_KEY + " must be positive.");
		}
	}

	public int getMaxIter() {
		return maxIter;
	}

	public void setMaxIter(int maxIter) {
		this.maxIter = maxIter;
	}

	public float getEpsilonRel() {
		return epsilonRel;
	}

	public void setEpsilonRel(float epsilonRel) {
		this.epsilonRel = epsilonRel;
	}

	public float getEpsilonAbs() {
		return epsilonAbs;
	}

	public void setEpsilonAbs(float epsilonAbs) {
		this.epsilonAbs = epsilonAbs;
	}

	public float getLagrangianPenalty() {
		return this.lagrangePenalty;
	}

	public float getAugmentedLagrangianPenalty() {
		return this.augmentedLagrangePenalty;
	}

	@Override
	public void optimize(TermStore baseTermStore) {
		InitialValue initialConsensus = InitialValue.valueOf(
				Config.getString(INITIAL_CONSENSUS_VALUE_KEY, INITIAL_CONSENSUS_VALUE_DEFAULT).toUpperCase());
		InitialValue initialLocal = InitialValue.valueOf(
				Config.getString(INITIAL_LOCAL_VALUE_KEY, INITIAL_LOCAL_VALUE_DEFAULT).toUpperCase());

		optimize(baseTermStore, initialConsensus, initialLocal);
	}

	public void optimize(TermStore baseTermStore, InitialValue initialConsensus, InitialValue initialLocal) {
		if (!(baseTermStore instanceof ADMMTermStore)) {
			throw new IllegalArgumentException("ADMMReasoner requires an ADMMTermStore (found " + baseTermStore.getClass().getName() + ").");
		}
		ADMMTermStore termStore = (ADMMTermStore)baseTermStore;

		termStore.resetLocalVairables(initialLocal);

		int numTerms = termStore.size();
		int numVariables = termStore.getNumGlobalVariables();

		log.debug("Performing optimization with {} variables and {} terms.", numVariables, numTerms);

		initConsensusValues(termStore, initialConsensus);

		termBlockSize = numTerms / (Parallel.getNumThreads() * 4) + 1;
		variableBlockSize = numVariables / (Parallel.getNumThreads() * 4) + 1;

		int numTermBlocks = (int)Math.ceil(numTerms / (float)termBlockSize);
		int numVariableBlocks = (int)Math.ceil(numVariables / (float)variableBlockSize);

		// Performs inference.
		float epsilonAbsTerm = (float)(Math.sqrt(termStore.getNumLocalVariables()) * epsilonAbs);

		float objective = 0.0f;
		float oldObjective = 0.0f;

		int iteration = 1;
		if (printObj) {
			log.trace("grepThis:Iterations,Time(ms),Objective");
			log.trace("grepThis:{},{},{}",
					iteration - 1, 0, computeObjective(termStore));
		}
		float time = 0;
		while (
				(iteration == 1 || primalRes > epsilonPrimal || dualRes > epsilonDual)
				&& (objectiveBreak && (MathUtils.isZero(oldObjective) || !MathUtils.equals(objective, oldObjective)))
				&& iteration <= maxIter) {
			// Zero out the iteration variables.
			primalRes = 0.0f;
			dualRes = 0.0f;
			AxNorm = 0.0f;
			AyNorm = 0.0f;
			BzNorm = 0.0f;
			lagrangePenalty = 0.0f;
			augmentedLagrangePenalty = 0.0f;
			long start = System.currentTimeMillis();

			// Minimize all the terms.
			Parallel.count(numTermBlocks, new TermWorker(termStore, termBlockSize));

			// Compute new consensus values and residuals.
			Parallel.count(numVariableBlocks, new VariableWorker(termStore, variableBlockSize));
			long end = System.currentTimeMillis();
			time += end - start;
			if (printObj) {
				log.trace("grepThis:{},{},{}",
						iteration - 1, time, computeObjective(termStore));
			}

			primalRes = (float)Math.sqrt(primalRes);
			dualRes = (float)(stepSize * Math.sqrt(dualRes));

			epsilonPrimal = (float)(epsilonAbsTerm + epsilonRel * Math.max(Math.sqrt(AxNorm), Math.sqrt(BzNorm)));
			epsilonDual = (float)(epsilonAbsTerm + epsilonRel * Math.sqrt(AyNorm));

			if (iteration % LOG_PERIOD == 0) {
				if (!objectiveBreak) {
					log.trace(
							"Iteration {} -- Primal: {}, Dual: {}, Epsilon Primal: {}, Epsilon Dual: {}.",
							iteration, primalRes, dualRes, epsilonPrimal, epsilonDual);
				} else {
					oldObjective = objective;

					objective = 0.0f;
					boolean feasible = true;

					if (log.isTraceEnabled()) {
						for (ADMMObjectiveTerm term : termStore) {
							if (term instanceof LinearConstraintTerm) {
								if (term.evaluate() > 0.0f) {
									feasible = false;
								}
							} else {
								objective += (1.0f - term.evaluate());
							}
						}
					}

					log.trace(
							"Iteration {} -- Objective: {}, Feasible: {}, Primal: {}, Dual: {}, Epsilon Primal: {}, Epsilon Dual: {}.",
							iteration, objective, feasible, primalRes, dualRes, epsilonPrimal, epsilonDual);
				}
			}

			iteration++;
		}

		log.info("Optimization completed in {} iterations. Primal res.: {}, Dual res.: {}",
				iteration - 1, primalRes, dualRes);

		// Updates variables
		termStore.updateVariables(consensusValues);
	}


	public float computeObjective(ADMMTermStore termStore){
		float obj = 0;
		int nTerms = 0;
		for (ADMMObjectiveTerm term : termStore){
			obj += term.evaluate();
			nTerms++;
		}
		return obj/nTerms;
	}

	@Override
	public void close() {
	}

	/**
	 * Computes the incompatibility of the local variable copies corresponding to GroundRule groundRule.
	 * The caller should provide a buffer that will be used to keep copies of the consensus values.
	 * It should be sized: termStore().getNumGlobalVariables().
	 * Null may be passed instead, but it will cause an allocation.
	 */
	public double getDualIncompatibility(GroundRule groundRule, ADMMTermStore termStore, float[] consensusBuffer) {
		if (consensusBuffer == null) {
			consensusBuffer = new float[termStore.getNumGlobalVariables()];
		}

		assert(consensusBuffer.length == consensusValues.length);

		// Set the global variables to the value of the local variables for this rule.
		for (Integer termIndex : termStore.getTermIndices((WeightedGroundRule)groundRule)) {
			for (LocalVariable localVariable : termStore.get(termIndex).getVariables()) {
				consensusBuffer[localVariable.getGlobalId()] = localVariable.getValue();
			}
		}

		// Updates variables
		termStore.updateVariables(consensusBuffer);
		double incompatibility = ((WeightedGroundRule)groundRule).getIncompatibility();

		// Reset the variables to the correct values.
		termStore.updateVariables(consensusValues);

		return incompatibility;
	}

	private void initConsensusValues(ADMMTermStore termStore, InitialValue initialConsensus) {
		consensusValues = new float[termStore.getNumGlobalVariables()];

		if (initialConsensus == InitialValue.ZERO) {
			for (int i = 0; i < consensusValues.length; i++) {
				consensusValues[i] = 0.0f;
			}
		} else if (initialConsensus == InitialValue.RANDOM) {
			for (int i = 0; i < consensusValues.length; i++) {
				consensusValues[i] = RandUtils.nextFloat();
			}
		} else if (initialConsensus == InitialValue.ATOM) {
			termStore.getAtomValues(consensusValues);
		} else {
			throw new IllegalStateException("Unknown initial consensus value: " + initialConsensus);
		}
	}

	private synchronized void updateIterationVariables(
			float primalRes, float dualRes,
			float AxNorm, float BzNorm, float AyNorm,
			float lagrangePenalty, float augmentedLagrangePenalty) {
		this.primalRes += primalRes;
		this.dualRes += dualRes;
		this.AxNorm += AxNorm;
		this.AyNorm += AyNorm;
		this.BzNorm += BzNorm;
		this.lagrangePenalty += lagrangePenalty;
		this.augmentedLagrangePenalty += augmentedLagrangePenalty;
	}

	private class TermWorker extends Parallel.Worker<Integer> {
		private ADMMTermStore termStore;
		private int blockSize;

		public TermWorker(ADMMTermStore termStore, int blockSize) {
			super();
			this.termStore = termStore;
			this.blockSize = blockSize;
		}

		public Object clone() {
			return new TermWorker(termStore, blockSize);
		}

		@Override
		public void work(int blockIndex, Integer ignore) {
			int numTerms = termStore.size();

			// Minimize each local function (wrt the local variable copies).
			for (int innerBlockIndex = 0; innerBlockIndex < blockSize; innerBlockIndex++) {
				int termIndex = blockIndex * blockSize + innerBlockIndex;

				if (termIndex >= numTerms) {
					break;
				}

				termStore.get(termIndex).updateLagrange(stepSize, consensusValues);
				termStore.get(termIndex).minimize(stepSize, consensusValues);
			}
		}
	}

	private class VariableWorker extends Parallel.Worker<Integer> {
		private ADMMTermStore termStore;
		private int blockSize;

		public VariableWorker(ADMMTermStore termStore, int blockSize) {
			super();
			this.termStore = termStore;
			this.blockSize = blockSize;
		}

		public Object clone() {
			return new VariableWorker(termStore, blockSize);
		}

		@Override
		public void work(int blockIndex, Integer ignore) {
			int numVariables = termStore.getNumGlobalVariables();

			float primalResInc = 0.0f;
			float dualResInc = 0.0f;
			float AxNormInc = 0.0f;
			float BzNormInc = 0.0f;
			float AyNormInc = 0.0f;
			float lagrangePenaltyInc = 0.0f;
			float augmentedLagrangePenaltyInc = 0.0f;

			// Instead of dividing up the work ahead of time,
			// get one job at a time so the threads will have more even workloads.
			for (int innerBlockIndex = 0; innerBlockIndex < blockSize; innerBlockIndex++) {
				int variableIndex = blockIndex * blockSize + innerBlockIndex;

				if (variableIndex >= numVariables) {
					break;
				}

				float total = 0.0f;
				int numLocalVariables = termStore.getLocalVariables(variableIndex).size();

				// First pass computes newConsensusValue and dual residual fom all local copies.
				for (int localVarIndex = 0; localVarIndex < numLocalVariables; localVarIndex++) {
					LocalVariable localVariable = termStore.getLocalVariables(variableIndex).get(localVarIndex);
					total += localVariable.getValue() + localVariable.getLagrange() / stepSize;

					AxNormInc += localVariable.getValue() * localVariable.getValue();
					AyNormInc += localVariable.getLagrange() * localVariable.getLagrange();
				}

				float newConsensusValue = total / numLocalVariables;
				newConsensusValue = Math.max(Math.min(newConsensusValue, UPPER_BOUND), LOWER_BOUND);

				float diff = consensusValues[variableIndex] - newConsensusValue;
				// Residual is diff^2 * number of local variables mapped to consensusValues element.
				dualResInc += diff * diff * numLocalVariables;
				BzNormInc += newConsensusValue * newConsensusValue * numLocalVariables;

				consensusValues[variableIndex] = newConsensusValue;

				// Second pass computes primal residuals.

				for (int localVarIndex = 0; localVarIndex < numLocalVariables; localVarIndex++) {
					LocalVariable localVariable = termStore.getLocalVariables(variableIndex).get(localVarIndex);

					diff = localVariable.getValue() - newConsensusValue;
					primalResInc += diff * diff;

					// compute Lagrangian penalties
					lagrangePenaltyInc += localVariable.getLagrange() * (localVariable.getValue() - consensusValues[variableIndex]);
					augmentedLagrangePenaltyInc += 0.5 * stepSize * Math.pow(localVariable.getValue() - consensusValues[variableIndex], 2);
				}
			}

			updateIterationVariables(primalResInc, dualResInc, AxNormInc, BzNormInc, AyNormInc, lagrangePenaltyInc, augmentedLagrangePenaltyInc);
		}
	}
}
