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
package org.linqs.psl.model.atom;

import org.linqs.psl.model.formula.Formula;
import org.linqs.psl.model.predicate.Predicate;
import org.linqs.psl.model.predicate.SpecialPredicate;
import org.linqs.psl.model.rule.arithmetic.expression.SummationAtomOrAtom;
import org.linqs.psl.model.term.Constant;
import org.linqs.psl.model.term.ConstantType;
import org.linqs.psl.model.term.DoubleAttribute;
import org.linqs.psl.model.term.IntegerAttribute;
import org.linqs.psl.model.term.LongAttribute;
import org.linqs.psl.model.term.StringAttribute;
import org.linqs.psl.model.term.Term;
import org.linqs.psl.model.term.UniqueIntID;
import org.linqs.psl.model.term.UniqueStringID;
import org.linqs.psl.model.term.Variable;
import org.linqs.psl.util.HashCode;

import java.util.Arrays;
import java.util.Set;

/**
 * A {@link Predicate} combined with the correct number of {@link Term Terms}
 * as arguments.
 *
 * Two Atoms are equal if their Predicate and arguments are equal. Note that this
 * means that their truth values might not match, or one might even be a
 * {@link QueryAtom}.
 */
public abstract class Atom implements Formula, SummationAtomOrAtom {
	protected Predicate predicate;
	protected Term[] arguments;
	protected int hashcode;

	/**
	 * The hashcode of the original argument array.
	 * Since Terms are immutable, we can use this to shortcut deep equality checks.
	 */
	private int originArgumentsHashcode;

	/**
	 * Type mismatches will throw an exception unless
	 * the types are trivially convertable like UniqueIntID and IntegerAttribute.
	 */
	protected Atom(Predicate predicate, Term[] args) {
		init(true, true, predicate, args);
	}

	protected void init(boolean copyArgs, boolean doValidation, Predicate predicate, Term[] args) {
		this.predicate = predicate;

		if (copyArgs) {
			arguments = Arrays.copyOf(args, args.length);
		} else {
			arguments = args;
		}

		if (doValidation) {
			validate();
		}

		hashcode = HashCode.build(HashCode.build(predicate), arguments);
		// Note that we are using Arrays.hashCode() instead of args.hashCode().
		// This will take the shallow hash of the args.
		originArgumentsHashcode = Arrays.hashCode(args);
	}

	/**
	 * Returns the predicate associated with this Atom.
	 *
	 * @return A predicate
	 */
	public Predicate getPredicate() {
		return predicate;
	}

	/**
	 * Returns the number of arguments to the associated predicate.
	 *
	 * @return The number of arguments
	 */
	public int getArity() {
		return predicate.getArity();
	}

	/**
	 * Returns the arguments associated with this atom.
	 *
	 * @return The arguments associated with this atom
	 */
	public Term[] getArguments() {
		return arguments;
	}

	@Override
	public Formula getDNF() {
		return this;
	}

	@Override
	public Set<Atom> getAtoms(Set<Atom> atoms) {
		atoms.add(this);
		return atoms;
	}

	/**
	 * Verifies that this atom has valid arguments.
	 * This will also convert arguments of the incorrect type into the declared type if they are trivially similar
	 * (eg. StringAttribute and UniqueStringID).
	 *
	 * @throws IllegalArgumentException
	 *				 if the number of arguments doesn't match the number of arguments
	 *				 of the predicate
	 * @throws IllegalArgumentException  if any argument is null
	 * @throws IllegalArgumentException
	 *				 if any argument is a {@link Constant} and does not match
	 *				 the Predicate's {@link ConstantType}.
	 */
	private void validate() {
		if (predicate.getArity() != arguments.length) {
			throw new IllegalArgumentException("Length of Schema does not match the number of arguments.");
		}

		for (int i = 0; i < arguments.length; i++) {
			if (arguments[i] == null) {
				throw new IllegalArgumentException("Arguments must not be null!");
			}

			// Variables do not need to be validated.
			if (arguments[i] instanceof Variable) {
				continue;
			}

			ConstantType declaredType = predicate.getArgumentType(i);

			// No conversion necessary.
			if (predicate.getArgumentType(i).isInstance((Constant)arguments[i])) {
				continue;
			}

			// Perform safe conversions.
			if (arguments[i] instanceof DoubleAttribute) {
				Double arg = ((DoubleAttribute)arguments[i]).getValue();

				// Doubles will not be truncated/rounded.
				if (declaredType == ConstantType.String) {
					arguments[i] = new StringAttribute(arg.toString());
				} else if (declaredType == ConstantType.UniqueStringID) {
					arguments[i] = new UniqueStringID(arg.toString());
				}
			} else if (arguments[i] instanceof IntegerAttribute) {
				Integer arg = ((IntegerAttribute)arguments[i]).getValue();

				// Integers are safe to convert to anything.
				if (declaredType == ConstantType.Double) {
					arguments[i] = new DoubleAttribute(arg.doubleValue());
				} else if (declaredType == ConstantType.Long) {
					arguments[i] = new LongAttribute(arg.longValue());
				} else if (declaredType == ConstantType.String) {
					arguments[i] = new StringAttribute(arg.toString());
				} else if (declaredType == ConstantType.UniqueIntID) {
					arguments[i] = new UniqueIntID(arg.intValue());
				} else if (declaredType == ConstantType.UniqueStringID) {
					arguments[i] = new UniqueStringID(arg.toString());
				} else if (declaredType == ConstantType.DeferredFunctionalUniqueID) {
					arguments[i] = new UniqueIntID(arg.intValue());
				}
			} else if (arguments[i] instanceof LongAttribute) {
				Long arg = ((LongAttribute)arguments[i]).getValue();

				// Longs are safe to convert to anything.
				if (declaredType == ConstantType.Double) {
					arguments[i] = new DoubleAttribute(arg.doubleValue());
				} else if (declaredType == ConstantType.Integer) {
					arguments[i] = new IntegerAttribute(arg.intValue());
				} else if (declaredType == ConstantType.String) {
					arguments[i] = new StringAttribute(arg.toString());
				} else if (declaredType == ConstantType.UniqueIntID) {
					arguments[i] = new UniqueIntID(arg.intValue());
				} else if (declaredType == ConstantType.UniqueStringID) {
					arguments[i] = new UniqueStringID(arg.toString());
				}
			} else if (arguments[i] instanceof StringAttribute) {
				String arg = ((StringAttribute)arguments[i]).getValue();

				// Strings can be parsed to anything.
				if (declaredType == ConstantType.Double) {
					arguments[i] = new DoubleAttribute(Double.valueOf(arg));
				} else if (declaredType == ConstantType.Integer) {
					arguments[i] = new IntegerAttribute(Integer.valueOf(arg));
				} else if (declaredType == ConstantType.Long) {
					arguments[i] = new LongAttribute(Long.valueOf(arg));
				} else if (declaredType == ConstantType.UniqueIntID) {
					arguments[i] = new UniqueIntID(Integer.parseInt(arg));
				} else if (declaredType == ConstantType.UniqueStringID) {
					arguments[i] = new UniqueStringID(arg);
				} else if (declaredType == ConstantType.DeferredFunctionalUniqueID) {
					arguments[i] = new UniqueStringID(arg);
				}
			} else if (arguments[i] instanceof UniqueIntID) {
				// Unique ids will not be converted to anything else (even though it may be safe).
				throw new IllegalArgumentException(
						String.format("Expected type %s at position %d but was given: %s (%s) for predicate %s -- %s",
						predicate.getArgumentType(i), i, arguments[i], arguments[i].getClass().getName(), predicate,
						"Unique identifiers cannot be converted to any other type."));
			} else if (arguments[i] instanceof UniqueStringID) {
				// Unique ids will not be converted to anything else (even though it may be safe).
				throw new IllegalArgumentException(
						String.format("Expected type %s at position %d but was given: %s (%s) for predicate %s -- %s",
						predicate.getArgumentType(i), i, arguments[i], arguments[i].getClass().getName(), predicate,
						"Unique identifiers cannot be converted to any other type."));
			}

			// Check if conversion failed.
			if (!(predicate.getArgumentType(i).isInstance((Constant)arguments[i]))) {
				throw new IllegalArgumentException(
						String.format("Expected type %s at position %d but was given: %s (%s) for predicate %s",
						predicate.getArgumentType(i), i, arguments[i], arguments[i].getClass().getName(), predicate));
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (predicate instanceof SpecialPredicate)  {
			s.append("(");
			if (predicate == SpecialPredicate.NotEqual) {
				s.append(arguments[0]);
				s.append(" != ");
				s.append(arguments[1]);
			} else if (predicate == SpecialPredicate.Equal) {
				s.append(arguments[0]);
				s.append(" == ");
				s.append(arguments[1]);
			} else if (predicate == SpecialPredicate.NonSymmetric) {
				s.append(arguments[0]);
				s.append(" % ");
				s.append(arguments[1]);
			} else {
				throw new UnsupportedOperationException(
						"Unrecognized SpecialPredicate: " + predicate);
			}
			s.append(")");
		} else {
			s.append(predicate.getName()).append("(");
			String connector = "";
			for (Term arg : arguments) {
				s.append(connector).append(arg);
				connector = ", ";
			}
			s.append(")");
		}

		return s.toString();
	}

	@Override
	public int hashCode() {
		return hashcode;
	}

	@Override
	public boolean equals(Object oth) {
		if (oth == this) {
			return true;
		}

		if (oth == null || !(oth instanceof Atom)) {
			return false;
		}

		Atom other = (Atom)oth;

		// First check the hashcode to reduce the time we have to do a deepEquals() on the arguments.
		// Note that the hashcode is not perfect, but provides a quick insurance on inequality.
		return hashCode() == other.hashCode() && predicate.equals(other.predicate) &&
				(this.originArgumentsHashcode == other.originArgumentsHashcode || Arrays.deepEquals(arguments, other.arguments));
	}

	@Override
	public Formula flatten() {
		// Atom's are already flat by nature.
		return this;
	}
}
