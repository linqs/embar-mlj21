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
package org.linqs.psl.model.rule.arithmetic.expression.coefficient;

import java.util.Map;
import java.util.Set;

import org.linqs.psl.model.rule.arithmetic.expression.ArithmeticRuleExpression;
import org.linqs.psl.model.rule.arithmetic.expression.SummationVariable;
import org.linqs.psl.model.term.Constant;

/**
 * Numeric coefficient in a {@link ArithmeticRuleExpression}.
 * <p>
 * Coefficient and its subclasses are composable to represent complex definitions.
 * Its subclasses are defined as inner classes, because there are
 * a lot of them and they are simple.
 */
public abstract class Coefficient {
	/**
	 * Get the value of a coefficient (which may require a reqursive descent).
	 * For performance reasons, instead of passing the full subtitution set this the method,
	 * we are only passing the number of substitutions there are.
	 * This may need to change in the future,
	 * but the cost is too high to justify unless it is necessary.
	 */
	public abstract double getValue(Map<SummationVariable, Integer> subs);

	/**
	 * Get a simplified version of this Coefficient, the Coefficient itself if it cannot be simplified further.
	 */
	public abstract Coefficient simplify();
}
