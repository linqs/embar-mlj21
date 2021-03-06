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

import java.util.Collections;
import java.util.List;

/**
 * Objective term for an ADMMReasoner that is based on a hyperplane in some way.
 *
 * Stores the characterization of the hyperplane as coeffs^T * x = constant
 * and projects onto the hyperplane.
 *
 * All coeffs must be non-zero.
 */
public abstract class HyperplaneTerm extends MarginalObjectiveTerm {
	protected final List<Float> coeffs;
	protected final float constant;

	HyperplaneTerm(List<AtomFunctionVariable> variables, List<Float> coeffs, float constant) {
		super(variables);

		assert(variables.size() == coeffs.size());

		this.coeffs = coeffs;
		this.constant = constant;
	}

	@Override
	public float getConstant() { return constant; }

	@Override
	public List<Float> getCoeffs() { return Collections.unmodifiableList(coeffs); }
	/**
	 * coeffs^T * x - constant
	 */
	@Override
	public float evaluate() {
		float value = 0.0f;
		for (int i = 0; i < variables.size(); i++) {
			value += coeffs.get(i).floatValue() * variables.get(i).getValue();
		}
		return value - constant;
	}
}
