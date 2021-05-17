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
package org.linqs.psl.database;

import org.linqs.psl.model.atom.AtomCache;
import org.linqs.psl.model.atom.GroundAtom;
import org.linqs.psl.model.atom.ObservedAtom;
import org.linqs.psl.model.atom.QueryAtom;
import org.linqs.psl.model.atom.RandomVariableAtom;
import org.linqs.psl.model.formula.Formula;
import org.linqs.psl.model.predicate.Predicate;
import org.linqs.psl.model.predicate.StandardPredicate;
import org.linqs.psl.model.term.Constant;
import org.linqs.psl.model.term.Term;
import org.linqs.psl.model.term.Variable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A data model for retrieving and persisting {@link GroundAtom GroundAtoms}.
 *
 * Every GroundAtom retrieved from a Database is either a {@link RandomVariableAtom}
 * or an {@link ObservedAtom}. The method {@link #getAtom(Predicate, Constant...)}
 * determines which type a GroundAtom is. In addition, a GroundAtom with a
 * {@link StandardPredicate} can be persisted in a Database. If a
 * GroundAtom is persisted, it is persisted in one of the Partitions the
 * Database can read and is available for querying via {@link #executeQuery(DatabaseQuery)}.
 *
 * <h2>Setup</h2>
 *
 * Databases are instantiated via {@link DataStore#getDatabase} methods.
 *
 * A Database writes to and reads from one {@link Partition} of a DataStore
 * and can read from additional Partitions. The write Partition of a Database
 * may not be a read (or write) Partition of any other Database managed by the datastore.
 *
 * A Database can be instantiated with a set of StandardPredicates
 * to close. (Any StandardPredicate not closed initially remains open.) Whether
 * a StandardPredicate is open or closed affects the behavior of
 * {@link #getAtom(Predicate, Constant...)}.
 *
 * <h2>Retrieving GroundAtoms</h2>
 *
 * A Database is the canonical source for a set of GroundAtoms.
 * GroundAtoms should only be retrieved via {@link #getAtom(Predicate, Constant...)}
 * to ensure there exists only a single object for each GroundAtom from the Database.
 *
 * A Database contains an {@link AtomCache} which is used to store GroundAtoms
 * that have been instantiated in memory and ensure these objects are unique.
 *
 * <h2>Persisting RandomVariableAtoms</h2>
 *
 * A RandomVariableAtom can be persisted (including updated) in the write
 * Partition via {@link #commit(RandomVariableAtom)} or
 * {@link RandomVariableAtom#commitToDB()}.
 *
 * <h2>Querying for Groundings</h2>
 *
 * {@link DatabaseQuery DatabaseQueries} can be run via {@link #executeQuery(DatabaseQuery)}.
 * Note that queries only act on the GroundAtoms persisted in Partitions and
 * GroundAtoms with FunctionalPredicates.
 */
public abstract class Database implements ReadableDatabase, WritableDatabase {
	/**
	 * The backing data store that created this database.
	 * Connection are obtained from here.
	 */
	protected final DataStore parentDataStore;

	/**
	 * The partition ID in which this database writes.
	 */
	protected final Partition writePartition;
	protected final int writeID;

	/**
	 * The partition IDs that this database reads from.
	 */
	protected final List<Partition> readPartitions;
	protected final List<Integer> readIDs;

	/**
	 * The atom cache for this database.
	 */
	protected final AtomCache cache;

	/**
	 * Keeps track of the open / closed status of this database.
	 */
	protected boolean closed;

	public Database(DataStore parent, Partition write, Partition[] read){
		this.parentDataStore = parent;
		this.writePartition = write;
		this.writeID = write.getID();

		this.readPartitions = Arrays.asList(read);
		this.readIDs = new ArrayList<Integer>(read.length);
		for (int i = 0; i < read.length; i++) {
			this.readIDs.add(read[i].getID());
		}

		if (!this.readIDs.contains(writeID)) {
			this.readIDs.add(writeID);
		}

		this.cache = new AtomCache(this);
	}

	public abstract GroundAtom getAtom(StandardPredicate predicate, boolean create, Constant... arguments);

	public boolean hasAtom(StandardPredicate predicate, Constant... arguments) {
		return getAtom(predicate, false, arguments) != null;
	}

	public int countAllGroundAtoms(StandardPredicate predicate) {
		List<Integer> partitions = new ArrayList<Integer>();
		partitions.addAll(readIDs);
		partitions.add(writeID);

		return countAllGroundAtoms(predicate, partitions);
	}

	public abstract int countAllGroundAtoms(StandardPredicate predicate, List<Integer> partitions);

	public int countAllGroundRandomVariableAtoms(StandardPredicate predicate) {
		// Closed predicates have no random variable atoms.
		if (isClosed(predicate)) {
			return 0;
		}

		// All the atoms should be random vairable, since we are pulling from the write parition of an open predicate.
		List<Integer> partitions = new ArrayList<Integer>(1);
		partitions.add(writeID);

		return countAllGroundAtoms(predicate, partitions);
	}

	public List<GroundAtom> getAllGroundAtoms(StandardPredicate predicate) {
		List<Integer> partitions = new ArrayList<Integer>();
		partitions.addAll(readIDs);
		partitions.add(writeID);

		return getAllGroundAtoms(predicate, partitions);
	}

	public abstract List<GroundAtom> getAllGroundAtoms(StandardPredicate predicate, List<Integer> partitions);

	public List<RandomVariableAtom> getAllGroundRandomVariableAtoms(StandardPredicate predicate) {
		// Closed predicates have no random variable atoms.
		if (isClosed(predicate)) {
			return new ArrayList<RandomVariableAtom>();
		}

		// All the atoms should be random vairable, since we are pulling from the write parition of an open predicate.
		List<Integer> partitions = new ArrayList<Integer>(1);
		partitions.add(writeID);
		List<GroundAtom> groundAtoms = getAllGroundAtoms(predicate, partitions);

		List<RandomVariableAtom> atoms = new ArrayList<RandomVariableAtom>(groundAtoms.size());
		for (GroundAtom atom : groundAtoms) {
			atoms.add((RandomVariableAtom)atom);
		}

		return atoms;
	}

	public List<ObservedAtom> getAllGroundObservedAtoms(StandardPredicate predicate) {
		// Note that even open predicates may have observed atoms (partially observed predicates).

		// Only pull from the read partitions.
		List<GroundAtom> groundAtoms = getAllGroundAtoms(predicate, readIDs);

		// All the atoms will be observed since we are pulling from only read partitions.
		List<ObservedAtom> atoms = new ArrayList<ObservedAtom>(groundAtoms.size());
		for (GroundAtom atom : groundAtoms) {
			atoms.add((ObservedAtom)atom);
		}

		return atoms;
	}

	public void commit(RandomVariableAtom atom) {
		List<RandomVariableAtom> atoms = new ArrayList<RandomVariableAtom>(1);
		atoms.add(atom);
		commit(atoms);
	}

	/**
	 * @return the DataStore backing this Database
	 */
	public DataStore getDataStore(){
		return parentDataStore;
	}

	public List<Partition> getReadPartitions() {
		return Collections.unmodifiableList(readPartitions);
	}

	public Partition getWritePartition() {
		return writePartition;
	}
}
