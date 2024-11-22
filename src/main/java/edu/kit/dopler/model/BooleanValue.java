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

public final class BooleanValue extends AbstractValue<Boolean> {

    public BooleanValue(Boolean value) {
        super(value);
    }

    public static BooleanValue getTrue() {
        return new BooleanValue(true);
    }

    public static BooleanValue getFalse() {
        return new BooleanValue(false);
    }

    @Override
    public Boolean getSMTValue() {
        return getValue();
    }
    
    @Override
    public String toString() {
    	return String.valueOf(getValue());
    }
}
