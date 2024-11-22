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

public class DecisionVisibilityCallExpression extends DecisionCallExpression {

	public DecisionVisibilityCallExpression(IDecision decision) {
		super(decision);
	}

	@Override
	public boolean evaluate() throws EvaluationException {
		return getDecision().isVisible();
	}

	@Override
	public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
		if (getDecision().getVisibilityCondition() instanceof LiteralExpression) {
			try {
				if (getDecision().getVisibilityCondition().evaluate()) {
					builder.add("(= " + "true" + " " + "true" + ")");
				} else {
					builder.add("(= " + "true" + " " + "false" + ")");
				}
			} catch (EvaluationException e) {
				throw new RuntimeException(e);
			}
		} else {
			getDecision().getVisibilityCondition().toSMTStream(builder, callingDecisionConst);
		}
	}

	@Override
	public String toString() {
		return String.format("getValue(%s)", getDecision());
	}
}
