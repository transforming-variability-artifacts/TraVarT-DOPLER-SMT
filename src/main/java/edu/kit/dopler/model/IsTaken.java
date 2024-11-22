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

public class IsTaken extends DecisionCallExpression {

	public static final String FUNCTION_NAME = "isTaken";

	public IsTaken(IDecision decision) {
		super(decision);
	}

	@Override
	public boolean evaluate() {
		return getDecision().isTaken();
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
		builder.add("(= ");
		builder.add(getDecision().toStringConstforSMT() + "_TAKEN_POST");
		builder.add(" ");
		builder.add("true");
		builder.add(")");
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", FUNCTION_NAME, getDecision());
	}
}
