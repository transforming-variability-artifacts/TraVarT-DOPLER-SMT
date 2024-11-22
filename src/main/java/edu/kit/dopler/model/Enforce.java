/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Fabian Eger
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package edu.kit.dopler.model;

import java.util.stream.Stream;

public abstract class Enforce extends ValueRestrictionAction {

	public static final String FUNCTION_NAME = "enforce";

	private final IValue<?> value;

	public Enforce(final IDecision<?> decision, final IValue<?> value) {
		super(decision);
		this.value = value;
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
		builder.add("(and");
		if (getDecision().getDecisionType() == Decision.DecisionType.ENUM) {

			builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() + "_"
					+ value.getValue() + "_POST" + " " + "true" + ")");

		} else {
			// builder.add("(= " + selectedDecisionString + "_" +
			// getDecision().toStringConstforSMT() + "_PRE" + value.getSMTValue().toString()
			// + ")");
			builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() + "_POST" + " "
					+ value.getSMTValue().toString() + ")");

		}
		builder.add("(= " + getDecision().toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that
																										// the decision
																										// also needs to
																										// be taken
																										// because of
																										// the encoding
		builder.add(")"); // closing and

	}

	public IValue<?> getValue() {
		return value;
	}
}
