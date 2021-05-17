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
package org.linqs.psl.reasoner.function;

import org.linqs.psl.model.atom.GroundAtom;

/**
 * A general function that can handle various cases.
 * The function is some linear combination of terms.
 * All constant values are merged together into a single constant.
 * Note that the design of this function is to reduce the number of
 * allocations at grounding time.
 */
public class GeneralFunction implements FunctionTerm {
	private final double[] coefficients;
	private final FunctionTerm[] terms;
	private int size;

	// All constants will get merged into this.
	private double constant;

	private boolean constantTerms;
	private boolean linearTerms;

	private boolean nonNegative;
	private boolean squared;

	public GeneralFunction(boolean nonNegative, boolean squared, int maxSize) {
		coefficients = new double[maxSize];
		terms = new FunctionTerm[maxSize];
		size = 0;
		constant = 0.0;

		this.nonNegative = nonNegative;
		this.squared = squared;
		constantTerms = true;
		linearTerms = true;
	}

	public double getConstant() {
		return constant;
	}

	public boolean isSquared() {
		return squared;
	}

	public boolean isNonNegative() {
		return nonNegative;
	}

	@Override
	public boolean isLinear() {
		return !squared && linearTerms;
	}

	@Override
	public boolean isConstant() {
		return constantTerms;
	}

	public void setSquared(boolean squared) {
		this.squared = squared;
	}

	public void setNonNegative(boolean nonNegative) {
		this.nonNegative = nonNegative;
	}

	/**
	 * Add a constant to the sum.
	 */
	public void add(double value) {
		constant += value;
	}

	/**
	 * Add a general term to the sum.
	 */
	public void add(double coefficient, FunctionTerm term) {
		// Merge constants.
		if (term.isConstant()) {
			constant += (coefficient * term.getValue());
			return;
		}

		if (size == terms.length) {
			throw new IllegalStateException(
					"More than the max terms added to the function. Max: " + terms.length);
		}

		terms[size] = term;
		coefficients[size] = coefficient;
		size++;

		constantTerms = constantTerms && term.isConstant();
		linearTerms = linearTerms && term.isLinear();
	}

	public int size() {
		return size;
	}

	public double getCoefficient(int index) {
		return coefficients[index];
	}

	public FunctionTerm getTerm(int index) {
		return terms[index];
	}

	@Override
	public double getValue() {
		double val = constant;

		for (int i = 0; i < size; i++) {
			val += terms[i].getValue() * coefficients[i];
		}

		if (nonNegative && val < 0.0) {
			return 0.0;
		}

		return squared ? (val * val) : val;
	}

	/**
	 * Get the value of this sum, but using the values passed in place of non-constants for the term.
	 * Note that the constants still apply.
	 * This is a fragile function that should only be called by the code that constructed
	 * this function in the first place,
	 * The passed in values must only contains entries for non-constant atoms (all constants get merged).
	 * The passed in values may be larger than the number of values actually used.
	 */
	public double getValue(double[] values) {
		double val = constant;

		for (int i = 0; i < size; i++) {
			val += coefficients[i] * values[i];
		}

		if (nonNegative && val < 0.0) {
			return 0.0;
		}

		return squared ? (val * val) : val;
	}

	/**
	 * Get the value of the sum, but replace the value of a single RVA with the given value.
	 * This should only be called by people who really know what they are doing.
	 * Note that the value of the RVA is NOT used, it is only used to find the matching function term.
	 * The general version of would be to just have a map,
	 * However, the common use case is just having one variable change value and this is typically
	 * very high traffic making the map (and autoboxing double) overhead noticable.
	 */
	public double getValue(GroundAtom replacementAtom, double replacementValue) {
		double val = constant;

		// Use numeric for loops instead of iterators in high traffic code.
		for (int i = 0; i < size; i++) {
			FunctionTerm term = terms[i];
			double coefficient = coefficients[i];

			// Only one instance of each atom exists and we are not tring to match a query atom.
			if (term instanceof AtomFunctionVariable &&
					((AtomFunctionVariable)term).getAtom() == replacementAtom) {
				val += coefficient * replacementValue;
			} else {
				val += coefficient * term.getValue();
			}
		}

		if (nonNegative && val < 0.0) {
			return 0.0;
		}

		return squared ? (val * val) : val;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();

		if (nonNegative) {
			string.append("max(0.0, ");
		} else {
			string.append("(");
		}

		string.append(constant);

		for (int i = 0; i < size; i++) {
			FunctionTerm term = terms[i];
			double coefficient = coefficients[i];

			string.append(" + ");
			string.append("" + coefficient + " * " + term.toString());
		}

		string.append(")");

		if (squared) {
			string.append("^2");
		}

		return string.toString();
	}
}
