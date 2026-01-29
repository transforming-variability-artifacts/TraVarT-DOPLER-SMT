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
import edu.kit.dopler.exceptions.EvaluationException;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface IExpression {

    boolean evaluate() throws EvaluationException;

    void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst);

    /**
     * Converts the current expression into a CP literal.
     *
     * @param model        the constraint programming model
     * @param decisionVars a map associating each decision of a dopler model with a list of CP variables representing it
     * @param isTakenVars  a map associating each decision of a dopler model with a boolean literal indicating whether the decision is taken
     * @return a CP literal that represents the expression in the model
     */
    Literal toCPLiteral(CpModel model, Map<IDecision<?>, List<IntVar>> decisionVars, Map<IDecision<?>, Literal> isTakenVars);
}
