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

public interface IAction {

    void execute() throws ActionExecutionException;

    void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString);


    /**
     * Adds conditional constraints representing the current action in the given CP model.
     * The action will only be executed (in the model) if the condition ({@code conditionLiteral}) holds.
     * If appropriate, the {@code conditionLiteral} will be appended to the {@code isTakenConditions} List of the affected decision.
     *
     * @param model             the constraint programming model to which the constraints will be added
     * @param conditionLiteral  a boolean literal representing the condition under which this action is executed
     * @param decisionVars      a map associating each decision of a dopler model with a list of CP variables representing it
     * @param isTakenVars       a map associating each decision of a dopler model with a boolean literal indicating whether the decision is taken
     * @param isTakenConditions a (helper) map associating each decision of a dopler model with a list of boolean literals that can later be used to add constraints for isTakenVars to be logically correct in the model
     */
    void executeAsCP(CpModel model, Literal conditionLiteral, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars, Map<IDecision<?>, List<Literal>> isTakenConditions);

}
