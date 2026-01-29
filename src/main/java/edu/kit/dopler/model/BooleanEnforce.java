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
import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.List;
import java.util.Map;

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
    public void executeAsCP(CpModel model, Literal conditionLiteral, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars, Map<IDecision<?>, List<Literal>> isTakenConditions) {
        //val to enforce = this.getValue()
        //val to be enforced = decisionVars.get(this.getDecision())
        model.addEquality(decisionVars.get(this.getDecision()).getFirst(), this.getValue().getCPValue(model))
                .onlyEnforceIf(conditionLiteral);

        isTakenConditions.get(this.getDecision()).add(conditionLiteral);
    }

    @Override
    public String toString() {
        return String.format("%s = %s", getDecision(), getValue());
    }
}
