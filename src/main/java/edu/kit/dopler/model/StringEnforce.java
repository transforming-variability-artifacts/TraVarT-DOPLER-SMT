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
/**
 * Because the Enforce Action is possible with every decision type and the decision are generic
 * we needed to add an abstract enforce class to then specialise them into the different decision type enforces
 *
 */
package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public class StringEnforce extends Enforce {

	public StringEnforce(IDecision<?> decision, IValue<?> value) {
		super(decision, value);
	}

	@Override
	public void execute() throws ActionExecutionException {
		try {
			StringDecision stringDecision = (StringDecision) getDecision();
			StringValue stringValue = (StringValue) getValue();
			stringDecision.setValue(stringValue);
			getDecision().setTaken(true);
		} catch (Exception e) {
			throw new ActionExecutionException(e);
		}
	}

	@Override
	public String toString() {
		return String.format("%s = \"%s\"", getDecision(), getValue());
	}
}
