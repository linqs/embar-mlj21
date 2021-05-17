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
package org.linqs.psl.reasoner.sgd;

import org.linqs.psl.config.Config;
import org.linqs.psl.reasoner.sgd.term.SGDObjectiveTerm;
import org.linqs.psl.reasoner.sgd.term.SGDTermStore;
import org.linqs.psl.reasoner.Reasoner;
import org.linqs.psl.reasoner.term.TermStore;
import org.linqs.psl.util.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Uses an ADMM optimization method to optimize its GroundRules.
 */
public class SGDReasoner implements Reasoner {
	private static final Logger log = LoggerFactory.getLogger(SGDReasoner.class);

	/**
	 * Prefix of property keys used by this class.
	 */
	public static final String CONFIG_PREFIX = "sgd";

	/**
	 * The maximum number of iterations of ADMM to perform in a round of inference.
	 */
	public static final String MAX_ITER_KEY = CONFIG_PREFIX + ".maxiterations";
	public static final int MAX_ITER_DEFAULT = 200;

	/**
	 * Stop if the objective has not changed since the last logging period (see LOG_PERIOD).
	 */
	public static final String OBJECTIVE_BREAK_KEY = CONFIG_PREFIX + ".objectivebreak";
	public static final boolean OBJECTIVE_BREAK_DEFAULT = true;

	/**
	 * The maximum number of iterations of ADMM to perform in a round of inference.
	 */
	public static final String OBJ_TOL = CONFIG_PREFIX + ".tol";
	public static final float OBJ_TOL_DEFAULT = 0.000001f;


	public static final String LEARNING_RATE = CONFIG_PREFIX + ".lr";
	public static final float LEARNING_RATE_DEFAULT = 1f;
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
	public static final String PRINT_OBJECTIVE = CONFIG_PREFIX + ".printobj";
	public static final boolean PRINT_OBJECTIVE_DEFAULT = true;

	private int maxIter;


	private float tol;
	private boolean printObj;
	private boolean objectiveBreak;

	public SGDReasoner() {
		maxIter = Config.getInt(MAX_ITER_KEY, MAX_ITER_DEFAULT);
		objectiveBreak = Config.getBoolean(OBJECTIVE_BREAK_KEY, OBJECTIVE_BREAK_DEFAULT);
		printObj = Config.getBoolean(PRINT_OBJECTIVE, PRINT_OBJECTIVE_DEFAULT);
		tol = Config.getFloat(OBJ_TOL, OBJ_TOL_DEFAULT);
	}

	public int getMaxIter() {
		return maxIter;
	}

	public void setMaxIter(int maxIter) {
		this.maxIter = maxIter;
	}

	@Override
	public void optimize(TermStore baseTermStore) {
		if (!(baseTermStore instanceof SGDTermStore)) {
			throw new IllegalArgumentException("SGDReasoner requires an SGDTermStore (found " + baseTermStore.getClass().getName() + ").");
		}
		SGDTermStore termStore = (SGDTermStore)baseTermStore;

		termStore.resetTerms();

		int numTerms = termStore.size();
		int numVariables = termStore.getNumGlobalVariables();

		log.debug("Performing optimization with {} variables and {} terms.", numVariables, numTerms);


		float objective = computeObjective(termStore);
		float oldObjective = Float.POSITIVE_INFINITY;

		int iteration = 1;
		if (printObj){
			log.info("Iterations, Time(ms), Objective");
			log.info("grepThis:{},{},{}",
					iteration-1, 0, objective);
		}
		float time = 0;
		while ((objectiveBreak && MathUtils.compare(objective, oldObjective, tol) != 0)
				&& iteration <= maxIter) {
			long start = System.currentTimeMillis();
			for (SGDObjectiveTerm term: termStore){
				term.minimize();
			}
			long end = System.currentTimeMillis();
			oldObjective = objective;
			objective = computeObjective(termStore);
			time += end - start;
			if (printObj){
				log.info("grepThis:{},{},{}",
						iteration, time, objective);
			}
			iteration++;
		}

		log.info("Optimization completed in {} iterations. Objective.: {}",
				iteration - 1, objective);

	}

	public float computeObjective(SGDTermStore termStore){
		float obj = 0;
		int nTerms = 0;
		for (SGDObjectiveTerm term : termStore){
			obj += term.evaluate();
			nTerms++;
		}
		return obj/nTerms;
	}

	@Override
	public void close() {
	}


}
