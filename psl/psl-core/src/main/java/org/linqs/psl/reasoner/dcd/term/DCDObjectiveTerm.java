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

import org.apache.commons.collections4.list.UnmodifiableList;
import org.linqs.psl.config.Config;
import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.WeightedTerm;

import java.util.List;

/**
 * A term in the objective to be optimized by an ADMMReasoner.
 */
public abstract class DCDObjectiveTerm implements WeightedTerm  {
	private static final String TRUNCATE_EVERY_STEP = "dcd.truncateEveryStep";
	protected final List<AtomFunctionVariable> variables;
	protected final List<Float> coeffs;
	protected final float constant;
	protected final float Qii;
	protected float weight;
	protected float lagrangeVar;
	private boolean truncateEveryStep;

	/**
	 * Caller releases control of |variables|.
	 */
	public DCDObjectiveTerm(List<AtomFunctionVariable> variables, List<Float> coeffs,
							float constant, float weight, float c) {
		this.variables = variables;
		assert(variables.size() == coeffs.size());
		this.truncateEveryStep = Config.getBoolean(TRUNCATE_EVERY_STEP, false);

		this.coeffs = coeffs;
		this.constant = constant;
		this.weight = weight*c;
		this.lagrangeVar = 0;
		float qii = 0f;
		for (int i = 0; i < coeffs.size(); i++) {
			qii += coeffs.get(i)*coeffs.get(i);
		}
		Qii = qii;
	}

	public void reset() {
		this.lagrangeVar = 0;
		for (int i = 0; i < variables.size(); i++) {
			variables.get(i).setValue(0);
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

	public float getLagrangeVar(){
		return lagrangeVar;
	}

	public float computeGradient() {
		float var = 0f;
		for (int i = 0; i < variables.size(); i++) {
			var += variables.get(i).getValue() * coeffs.get(i);
		}
		return constant - var;
	}

	/**
	 * Updates x to the solution of <br />
	 * argmin f(x) + stepSize / 2 * \|x - z + y / stepSize \|_2^2 <br />
	 * for the objective term f(x)
	 */
	public abstract void minimize();

	/*
	                G = -((self.rvg.T.dot(self.data.dense_data[i])) - self.data.coeff[i])
                if self.data.l_fn_pow[i] == 2:
                    G += alphas[i] * 1/(2*self.data.weights[i])
                if alphas[i] == 0:
                    PG = min(G, 0)
                elif self.data.l_fn_pow[i] == 1 and alphas[i] == self.data.weights[i]:
                    PG = max(G, 0)
                else:
                    PG = G
                if PG != 0:
                    pa = alphas[i]
                    lim = self.data.weights[i] if self.data.l_fn_pow[i] == 1 else np.infty
                    alphas[i] = min(max(alphas[i] - G/Qs[i,i], 0), lim)
                    self.rvg = self.rvg - (alphas[i] - pa)*self.data.dense_data[i]
                    self.rvg[self.rvg<0] = 0
                    self.rvg[self.rvg>1] = 1
                    converges += np.abs(alphas[i] - pa)
	 */
	protected void minimize(float grad, float lim) {
		float pg = grad;
		if (lagrangeVar == 0){
			pg = Math.min(grad, 0);
		}
		if (lim == weight && lagrangeVar == weight){
			pg = Math.max(grad, 0);
		}
		if (pg != 0) {
			float pa = lagrangeVar;
			lagrangeVar = Math.min(Math.max(lagrangeVar - grad/Qii, 0), lim);
			for (int i = 0; i < variables.size(); i++) {
				double val = variables.get(i).getValue() - ((lagrangeVar - pa) * coeffs.get(i));
				if (truncateEveryStep) {
					val = Math.max(Math.min(val, 1), 0);
				}
				variables.get(i).setValue(val);
			}
		}
	}


	public float evaluate() {
		float value = 0.0f;
		for (int i = 0; i < variables.size(); i++) {
			value += coeffs.get(i).floatValue() * variables.get(i).getValue();
		}
		return value - constant;
	}
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
