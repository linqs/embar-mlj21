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

import org.apache.commons.collections4.list.UnmodifiableList;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.Term;

import java.util.List;

/**
 * A term in the objective to be optimized by an MarginalReasoner.
 */
public abstract class MarginalObjectiveTerm implements Term {
	protected final List<AtomFunctionVariable> variables;

	/**
	 * Caller releases control of |variables|.
	 */
	public MarginalObjectiveTerm(List<AtomFunctionVariable> variables) {
		this.variables = variables;
	}

	public abstract float evaluate();

	public List<AtomFunctionVariable> getVariables() {
		return new UnmodifiableList<AtomFunctionVariable>(variables);
	}

	public abstract float getWeight() ;

	public abstract List<Float> getCoeffs() ;

	public  abstract float getConstant() ;

	@Override
	public  String toString(){
		String varsStr = "";
		String coeffsStr = "";
		List<AtomFunctionVariable> vars = getVariables();
		List<Float> coeffs = getCoeffs();
		for (int i = 0; i < vars.size(); i++) {
			coeffsStr += coeffs.get(i).toString() + ", ";
			varsStr += vars.get(i).toString() + ", ";
		}
		String constant = Float.toString(getConstant());
		return "Vars: " + varsStr + "coeffs: " + coeffsStr + "constant: " + constant;
	}
}
