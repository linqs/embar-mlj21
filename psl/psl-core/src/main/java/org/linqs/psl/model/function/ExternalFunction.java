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
package org.linqs.psl.model.function;

import org.linqs.psl.database.ReadableDatabase;
import org.linqs.psl.model.term.Constant;
import org.linqs.psl.model.term.ConstantType;

public interface ExternalFunction {
	public double getValue(ReadableDatabase db, Constant... args);

	public int getArity();

	public ConstantType[] getArgumentTypes();
}
