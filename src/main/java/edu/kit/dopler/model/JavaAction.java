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
import com.google.ortools.sat.IntVar;
import com.google.ortools.sat.Literal;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JavaAction extends Action {
    @Override
    public void execute() {

    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        // not implemented yet
    }

    @Override
    public void executeAsCP(CpModel model, Literal conditionLiteral, Map<IDecision<?>, List<IntVar>> cpVars, Map<IDecision<?>, List<Literal>> isTakenVars) {
        throw new UnsupportedOperationException("Not supported in the current CP-approach.");
    }

    @Override
    public String toString() {
        return "not yet implemented";
    }
}
