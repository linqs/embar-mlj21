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
package org.linqs.psl.reasoner.sgd.term;

import org.linqs.psl.config.Config;
import org.linqs.psl.model.rule.GroundRule;
import org.linqs.psl.model.rule.WeightedGroundRule;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.TermStore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A TermStore specifically for ADMM terms.
 * The actually terms will just be held in a standard TermStore (a MemoryTermStore if not specified).
 * This class will focus on keeping track of the variables in the terms.
 */
public class SGDTermStore implements TermStore<SGDObjectiveTerm> {
	public static final String CONFIG_PREFIX = "sgdmemorytermstore";

	/**
	 * Initial size for the memory store.
	 */
	public static final String INTERNAL_STORE_KEY = CONFIG_PREFIX + ".internalstore";
	public static final String INTERNAL_STORE_DEFAULT = "org.linqs.psl.reasoner.term.MemoryTermStore";

	// Keep an internal store to hold the terms while this class focus on variables.
	private TermStore<SGDObjectiveTerm> store;

	private Map<AtomFunctionVariable, Integer> variableIndexes;

	/**
	 * The total number of all local variables (the sum of the sizes of each listin |localVariables|.
	 */
	private int numLocalVariables;

	@SuppressWarnings("unchecked")
	public SGDTermStore() {
		this((TermStore<SGDObjectiveTerm>)Config.getNewObject(INTERNAL_STORE_KEY, INTERNAL_STORE_DEFAULT));
	}

	public SGDTermStore(TermStore<SGDObjectiveTerm> store) {
		this.store = store;
		variableIndexes = new HashMap<AtomFunctionVariable, Integer>();
		numLocalVariables = 0;
	}

	/**
	 * Create a local variable and ensure that a global copy is registered.
	 */
	public synchronized void registerVariable(AtomFunctionVariable atomVariable) {

		int globalId;
		// Check if the global copy has already been registered.
		if (variableIndexes.containsKey(atomVariable)) {
			globalId = variableIndexes.get(atomVariable).intValue();
		} else {
			// If the global copy has not been registered, register it and prep it's local copies.
			globalId = variableIndexes.size();
			variableIndexes.put(atomVariable, globalId);
		}

	}

	public int getNumGlobalVariables() {
		return variableIndexes.size();
	}

	/**
	 * Update the global variables (AtomFunctionVariables).
	 * The passed in values in indexed according to global id.
	 */
	public void updateVariables(float[] values) {
		for (Map.Entry<AtomFunctionVariable, Integer> entry : variableIndexes.entrySet()) {
			entry.getKey().setValue(values[entry.getValue().intValue()]);
		}
	}

	/**
	 * Get the values from the atoms corresponding to global (consensus)
	 * variables and put them in the output array.
	 */
	public void getAtomValues(float[] values) {
		for (Map.Entry<AtomFunctionVariable, Integer> entry : variableIndexes.entrySet()) {
			values[entry.getValue().intValue()] = (float)entry.getKey().getValue();
		}
	}


	@Override
	public void add(GroundRule rule, SGDObjectiveTerm term) {
		store.add(rule, term);
	}

	@Override
	public void clear() {
		if (store != null) {
			store.clear();
		}

		if (variableIndexes != null) {
			variableIndexes.clear();
		}

		numLocalVariables = 0;
	}

	@Override
	public void close() {
		clear();

		if (store != null) {
			store.close();
			store = null;
		}

		variableIndexes = null;
	}

	public void resetTerms() {
		for (SGDObjectiveTerm term: this){
			term.reset();
		}
	}

	@Override
	public SGDObjectiveTerm get(int index) {
		return store.get(index);
	}

	@Override
	public int size() {
		return store.size();
	}

	@Override
	public void ensureCapacity(int capacity) {
		store.ensureCapacity(capacity);
	}

	@Override
	public Iterator<SGDObjectiveTerm> iterator() {
		return store.iterator();
	}

	@Override
	public void updateWeight(WeightedGroundRule rule) {
		store.updateWeight(rule);
	}

	@Override
	public List<Integer> getTermIndices(WeightedGroundRule rule) {
		return store.getTermIndices(rule);
	}
}
