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

import edu.kit.dopler.exceptions.ActionExecutionException;

public class BooleanEnforce extends Enforce {

	public BooleanEnforce(BooleanDecision decision, IValue<Boolean> value) {
		super(decision, value);
	}

	@Override
	public void execute() throws ActionExecutionException {
		try {
			BooleanDecision booleanIDecision = (BooleanDecision) getDecision();
			BooleanValue booleanIValue = (BooleanValue) getValue();
			booleanIDecision.setValue(booleanIValue);
			getDecision().setTaken(true);
		} catch (Exception e) {
			throw new ActionExecutionException(e);
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s = %s", getDecision(), getValue());
	}
}
