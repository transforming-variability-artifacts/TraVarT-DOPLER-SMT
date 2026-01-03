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
import java.util.stream.Stream;

public class Allows extends ValueRestrictionAction {

    public static final String FUNCTION_NAME = "Allow";

    private final IValue<?> allowedValue;

    public Allows(EnumerationDecision decision, IValue<?> allowedValue) {
        super(decision);
        this.allowedValue = allowedValue;
    }

    @Override
    public void execute() throws ActionExecutionException {
        try {
            // check is needed because this action should only be possible on enumeration
            // decisions
            if (getDecision().getDecisionType() == Decision.DecisionType.ENUM) {

                EnumerationDecision enumerationDecision = (EnumerationDecision) getDecision();
                EnumerationLiteral enumerationLiteral = new EnumerationLiteral((String) allowedValue.getValue());
                enumerationDecision.removeDissallowed(enumerationLiteral);

            } else {
                throw new ActionExecutionException("Action only possible for DecisionType Enum");
            }

        } catch (Exception e) {
            throw new ActionExecutionException(e);
        }
    }

    @Override
    public void executeAsCP(CpModel model, Literal conditionLiteral, Map<IDecision<?>, List<IntVar>> cpVars, Map<IDecision<?>, List<Literal>> isTakenVars) {
        //nothing to do here
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        // should not change anything in the SMT stream
        // solver already checks the whole range of the value
    }

    @Override
    public String toString() {
        return String.format("%s(%s.%s)", FUNCTION_NAME, getDecision().getDisplayId(), allowedValue);
    }
}
