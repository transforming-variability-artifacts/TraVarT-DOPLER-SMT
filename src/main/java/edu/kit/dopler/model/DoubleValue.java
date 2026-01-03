/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 *    @author Johannes von Geisau
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.LinearArgument;

import java.util.Objects;

public class DoubleValue extends AbstractValue<Double> {

    public DoubleValue(final double value) {
        super(Objects.requireNonNull(value));
    }

    @Override
    public Double getSMTValue() {
        return getValue();
    }

    @Override
    public LinearArgument getCPValue(CpModel model) {
        throw new UnsupportedOperationException("should not be called in CP-approach"); //the CP approach uses getValue() and then the utility method scaleDoubleToCp(double value) to get a cp usable DoubleValue
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
