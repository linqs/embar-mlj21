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

import org.apache.commons.collections4.list.UnmodifiableList;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.WeightedTerm;
import org.linqs.psl.util.RandUtils;

import java.util.List;

/**
 * A term in the objective to be optimized by an ADMMReasoner.
 */
public abstract class SGDObjectiveTerm implements WeightedTerm  {
	protected final List<AtomFunctionVariable> variables;
	protected final List<Float> coeffs;
	protected final float constant;
	protected float weight;
	protected float lr;
	protected int iterCount;

	/**
	 * Caller releases control of |variables|.
	 */
	public SGDObjectiveTerm(List<AtomFunctionVariable> variables, List<Float> coeffs,
							float constant, float weight, float learningRate) {
		this.variables = variables;
		assert(variables.size() == coeffs.size());

		this.coeffs = coeffs;
		this.constant = constant;
		this.weight = weight;
		this.lr = learningRate;
		iterCount = 1;
	}

	public void reset() {
		iterCount = 1;
		for (int i = 0; i < variables.size(); i++) {
			variables.get(i).setValue(RandUtils.nextDouble());
		}
	}

	@Override
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public float getWeight() {
		return weight;
	}

	public abstract float computeGradient(int varId, float dot) ;


	/*
if self.data.dense_data[i].dot(self.rvg) - self.data.coeff[i] >= 0:
                        if self.data.l_fn_pow[i] == 1:
                            grad = self.data.weights[i]*(self.lr/float(k+1))*self.data.dense_data[i,j]
                        elif self.data.l_fn_pow[i] == 2:
                            grad = self.data.weights[i]*(self.lr/float(k+1))*2*(self.data.csr_data[i].dot(self.rvg)-self.data.coeff[i])*self.data.dense_data[i,j]
                        else:
                            print("Error: Found power {} which is neither 1 or 2. ".format(self.data.l_fn_pow[i]))
                            return None
                       self.rvg[j] = max([min([self.rvg[j] - grad, 1]), 0])
	 */
	public void minimize() {
		for (int i = 0 ; i < variables.size() ; i++) {
			AtomFunctionVariable var = variables.get(i);
			float dot = dot();
			float grad = 0;
			if (dot >= 0) {
				grad = computeGradient(i, dot);
			}
			var.setValue(Math.max(Math.min(var.getValue() - grad, 1),0));
		}
		iterCount++;
	}

	protected float dot(){
		float value = 0.0f;
		for (int i = 0; i < variables.size(); i++) {
			value += coeffs.get(i).floatValue() * variables.get(i).getValue();
		}
		return value - constant;
	}

	public abstract float evaluate() ;

	public List<AtomFunctionVariable> getVariables() {
		return new UnmodifiableList<AtomFunctionVariable>(variables);
	}

	public List<Float> getCoeffs() {
		return new UnmodifiableList<Float>(coeffs);
	}

	public float getConstant() {
		return constant;
	}
}
