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

import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.WeightedTerm;

import java.util.Collections;
import java.util.List;

/**
 * ADMMReasoner objective term of the form <br />
 * weight * coeffs^T * x
 */
public class LinearLossTerm extends MarginalObjectiveTerm implements WeightedTerm {
	private final List<Float> coeffs;
	private float weight;

	/**
	 * Caller releases control of |variables| and |coeffs|.
	 */
	LinearLossTerm(List<AtomFunctionVariable> variables, List<Float> coeffs, float weight) {
		super(variables);

		assert(variables.size() == coeffs.size());

		this.coeffs = coeffs;
		setWeight(weight);
	}

	@Override
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public float getWeight() {
		return weight;
	}
	
	@Override
	public float getConstant() { return 0; }

	@Override
	public List<Float> getCoeffs() { return Collections.unmodifiableList(coeffs); }

	/**
	 * weight * coeffs^T * x
	 */
	@Override
	public float evaluate() {
		float value = 0.0f;
		for (int i = 0; i < variables.size(); i++) {
			value += coeffs.get(i).floatValue() * variables.get(i).getValue();
		}
		return weight * value;
	}
}
