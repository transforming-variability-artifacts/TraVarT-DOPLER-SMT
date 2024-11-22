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

public class DecisionValueCallExpression extends DecisionCallExpression {

	public DecisionValueCallExpression(IDecision decision) {
		super(decision);
	}

	@Override
	public boolean evaluate() {
		return getDecision().isTaken();
	}

	public IValue<?> getValue() {
		return getDecision().getValue();
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
		builder.add(" " + callingDecisionConst + "_" + getDecision().toStringConstforSMT() + "_PRE ");
	}

	@Override
	public String toString() {
		return String.format("getValue(%s)", getDecision());
	}
}
