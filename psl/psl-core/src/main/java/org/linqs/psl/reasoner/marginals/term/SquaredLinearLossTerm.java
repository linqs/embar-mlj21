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

import java.util.List;

/**
 * ADMMReasoner objective term of the form <br />
 * weight * (coeffs^T * x - constant)^2
 */
public class SquaredLinearLossTerm extends SquaredHyperplaneTerm {
	SquaredLinearLossTerm(List<AtomFunctionVariable> variables, List<Float> coeffs, float constant, float weight) {
		super(variables, coeffs, constant, weight);
	}

	/**
	 * weight * (coeffs^T * x - constant)^2
	 */
	@Override
	public float evaluate() {
		return weight * (float)Math.pow(super.evaluate(), 2);
	}
}
