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

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class NOT extends UnaryExpression {
	
	private static final String SYMBOL = "!";

	public NOT(IExpression operand) {
		super(operand);
	}

	@Override
	public boolean evaluate() throws EvaluationException {
		return !getOperand().evaluate();
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
		builder.add("(not ");
		getOperand().toSMTStream(builder, callingDecisionConst);
		builder.add(")");
	}

	@Override
	public String toString() {
		return String.format("%s%s", SYMBOL, getOperand());
	}
}
