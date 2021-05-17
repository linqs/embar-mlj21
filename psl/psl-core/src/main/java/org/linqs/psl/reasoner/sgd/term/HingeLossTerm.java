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

import org.linqs.psl.reasoner.function.AtomFunctionVariable;
import org.linqs.psl.reasoner.term.WeightedTerm;

import java.util.List;

/**
 * ADMMReasoner objective term of the form <br />
 * weight * max(coeffs^T * x - constant, 0)
 *
 * All coeffs must be non-zero.
 */
public class HingeLossTerm extends SGDObjectiveTerm implements WeightedTerm {

	HingeLossTerm(List<AtomFunctionVariable> variables, List<Float> coeffs,
				  float constant, float weight, float c) {
		super(variables, coeffs, constant, weight, c);
	}

	//grad = self.data.weights[i]*(self.lr/float(k+1))*self.data.dense_data[i,j]
	@Override
	public float computeGradient(int varId, float dot) {
		return weight * (lr/iterCount)*coeffs.get(varId);
	}


	/**
	 * weight * max(coeffs^T * x - constant, 0)
	 */
	@Override
	public float evaluate() {
		return weight * Math.max(dot(), 0.0f);
	}
}
