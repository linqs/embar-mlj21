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
package org.linqs.psl.reasoner.marginals.term;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.linqs.psl.application.groundrulestore.GroundRuleStore;
import org.linqs.psl.config.Config;
import org.linqs.psl.model.rule.GroundRule;
import org.linqs.psl.model.rule.WeightedGroundRule;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.TermStore;

import java.util.*;

/**
 * A TermStore specifically for ADMM terms.
 * The actually terms will just be held in a standard TermStore (a MemoryTermStore if not specified).
 * This class will focus on keeping track of the variables in the terms.
 */
public class MarginalTermStore implements TermStore<MarginalObjectiveTerm> {
	public static final String CONFIG_PREFIX = "marginalmemorytermstore";

	/**
	 * Initial size for the memory store.
	 */
	public static final String INTERNAL_STORE_KEY = CONFIG_PREFIX + ".internalstore";
	public static final String INTERNAL_STORE_DEFAULT = "org.linqs.psl.reasoner.term.MemoryTermStore";

	// Keep an internal store to hold the terms while this class focus on variables.
	private TermStore<MarginalObjectiveTerm> store;

	private BiMap<AtomFunctionVariable, Integer> variableIndexes;
	private Map<AtomFunctionVariable, ArrayList<MarginalObjectiveTerm> > variableToTerm;
	private GroundRuleStore ruleStore;

	@SuppressWarnings("unchecked")
	public MarginalTermStore() {
		this((TermStore<MarginalObjectiveTerm>)Config.getNewObject(INTERNAL_STORE_KEY, INTERNAL_STORE_DEFAULT));
	}

	public MarginalTermStore(TermStore<MarginalObjectiveTerm> store) {
		this.store = store;
		variableIndexes = HashBiMap.create();
		variableToTerm = new HashMap<AtomFunctionVariable, ArrayList<MarginalObjectiveTerm>>();
	}

	/**
	 * Create a local variable and ensure that a global copy is registered.
	 */
	public synchronized void addTermAssociatedWithVariable(MarginalObjectiveTerm term) {
		for (AtomFunctionVariable atomVariable : term.getVariables()) {
			// Check if the global copy has already been registered.
			if (!variableIndexes.containsKey(atomVariable)) {
				// If the global copy has not been registered, register it and prep it's local copies.
				int globalId = variableIndexes.size();
				variableIndexes.put(atomVariable, globalId);
				variableToTerm.put(atomVariable, new ArrayList<MarginalObjectiveTerm>());
			}
			List<MarginalObjectiveTerm> terms = variableToTerm.get(atomVariable);
			terms.add(term);
		}

	}

	public Set<AtomFunctionVariable> getAllVariables () {
		return Collections.unmodifiableSet(variableToTerm.keySet());
	}

	public List<MarginalObjectiveTerm> getTermsUsingVar(AtomFunctionVariable var){
		return Collections.unmodifiableList(variableToTerm.get(var));
	}

	public int getNumVariables() {
		return variableIndexes.size();
	}

	public AtomFunctionVariable getVariable(int gid){
		return variableIndexes.inverse().get(gid);
	}

	public int getIndex(AtomFunctionVariable var){
		return variableIndexes.get(var);
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


	@Override
	public void add(GroundRule rule, MarginalObjectiveTerm term) {
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
		if (variableToTerm != null) {
			variableToTerm.clear();
		}

	}

	@Override
	public void close() {
		clear();

		if (store != null) {
			store.close();
			store = null;
		}

		variableIndexes = null;
		variableToTerm = null;
	}

	@Override
	public MarginalObjectiveTerm get(int index) {
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
	public Iterator<MarginalObjectiveTerm> iterator() {
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

	public void saveGroundRuleStore(GroundRuleStore ruleStore) {
		this.ruleStore = ruleStore;
	}

	public GroundRuleStore getRuleStore(){
		return ruleStore;
	}
}
