/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors:
 *    @author JOhannes von Geisau
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.common;

import com.google.ortools.sat.*;

import java.util.List;
import java.util.Objects;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

/**
 * Represents the result of encoding a DOPLER model in a constraint programming (CP) model.
 * Provides functionalities to check satisfiability, print configurations, and calculate the total number of solutions.
 */
public final class CpEncodingResult {
    /**
     * CP does not support floating point values (only integers).
     * We use integers scaled with {@value CP_DOUBLES_SCALING_FACTOR} to emulate floating point values.
     */
    private static final Double CP_DOUBLES_SCALING_FACTOR = 0.0001;

    private final CpModel model;
    private final List<List<IntVar>> variables;

    /**
     * Constructs a new CpEncodingResult object.
     *
     * @param model     The constraint programming model associated with this result.
     * @param variables A list of lists containing CP variables for the model.
     *                  Each inner list represents variables of a single decision.
     */
    public CpEncodingResult(CpModel model, List<List<IntVar>> variables) {
        this.model = Objects.requireNonNull(model);
        this.variables = List.copyOf(variables);
    }

    /**
     * Scales a double value to a long value that can be used by the CP solver.
     *
     * @param value The double value to be scaled.
     * @return The resulting long value after scaling and rounding.
     */
    public static Long scaleDoubleToCp(double value) {
        return Math.round(value / CP_DOUBLES_SCALING_FACTOR);
    }

    private Double scaleCpToDouble(Long value) {
        return value * CP_DOUBLES_SCALING_FACTOR;
    }

    public CpModel getModel() {
        return model;
    }

    public List<List<IntVar>> getVariables() {
        return variables;
    }

    /**
     * Determines the satisfiability of the CpEncodingResult.
     *
     * @return True if the model is satisfiable (has feasible or optimal solutions), false otherwise.
     */
    public boolean checkSat() {
        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(this.model);

        return status == CpSolverStatus.FEASIBLE || status == CpSolverStatus.OPTIMAL;
    }

    /**
     * Calculates the total number of configurations (solutions) of the CpEncodingResult.
     * Note: This operation may take a significant amount of time for large models!
     *
     * @return The total number of solutions found.
     */
    public int getAmountOfConfigs() {
        CpSolver solver = new CpSolver();
        solver.getParameters().setEnumerateAllSolutions(true);

        // Local callback that simply counts each solution visited by the solver.
        class SolutionCounter extends CpSolverSolutionCallback {
            private int solutionCount = 0;

            @Override
            public void onSolutionCallback() {
                solutionCount++;
            }

            int getSolutionCount() {
                return solutionCount;
            }
        }

        SolutionCounter counter = new SolutionCounter();
        solver.solve(this.model, counter);
        return counter.getSolutionCount();
    }


    /**
     * Solves the CpEncodingResult and prints one satisfiable configuration, if available.
     */
    public void printOneConfig() {
        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(this.model);

        if (status == CpSolverStatus.OPTIMAL || status == CpSolverStatus.FEASIBLE) {
            System.out.printf("Solution found, time = %.2f s%n", solver.wallTime());
            for (List<IntVar> vars : this.variables) {
                printCPDecisionVariables(vars, solver::value);
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    /**
     * Solves the CpEncodingResult and prints all possible configurations.
     * Note: This operation may take a significant amount of time for large models!
     */
    public void printAllConfigs() {
        CpSolver solver = new CpSolver();

        // Local callback that prints each solution visited by the solver.
        class VarArraySolutionPrinter extends CpSolverSolutionCallback {
            private final List<List<IntVar>> variables;
            private int solutionCount = 0;

            public VarArraySolutionPrinter(List<List<IntVar>> variables) {
                this.variables = variables;
            }

            @Override
            public void onSolutionCallback() {
                System.out.printf("Solution #%d, time = %.2f s%n", solutionCount, wallTime());
                for (List<IntVar> vars : this.variables) {
                    printCPDecisionVariables(vars, this::value);
                }
                solutionCount++;
            }

            public int getSolutionCount() {
                return solutionCount;
            }
        }

        VarArraySolutionPrinter printer = new VarArraySolutionPrinter(this.variables);
        solver.getParameters().setEnumerateAllSolutions(true);
        solver.solve(this.model, printer);
        System.out.println("#solutions: " + printer.getSolutionCount());
    }

    private void printCPDecisionVariables(List<IntVar> vars, ToLongFunction<IntVar> getValue) {
        if (vars == null || vars.isEmpty()) return;

        if (vars.size() == 1) {
            IntVar variable = vars.getFirst();
            long value = getValue.applyAsLong(variable);
            if (variable instanceof BoolVar) {
                //bool:
                System.out.printf("  %s = %s%n", variable.getName(), value == 1 ? "true" : "false");
            } else {
                //number:
                System.out.printf("  %s = %f%n", variable.getName(), scaleCpToDouble(value));
            }
        } else {
            //enum:
            String literals = vars.stream().filter(var -> getValue.applyAsLong(var) == 1).map(var -> var.getName().split("_")[1]).sorted().collect(Collectors.joining(", "));
            System.out.printf("  %s = [%s]%n", vars.getFirst().getName().split("_")[0], literals);
        }
    }

    /**
     * Identifies and prints anomalies in the CpEncodingResult.
     * Specifically, this method analyzes and outputs dead decision values and false optional decision values.
     * <p>
     * It achieves this by invoking the respective methods:
     * <ul>
     *     <li>{@link #printDeadDecisionValues()}</li>
     *     <li>{@link #printFalseOptionalDecisionValues()}</li>
     * </ul>
     *
     * @return True if at least one anomaly was found, false otherwise.
     */
    public boolean printAnomalies() {
        return printDeadDecisionValues() || printFalseOptionalDecisionValues();
    }

    /**
     * Identifies and prints dead decisions (that can never be true) in the CpEncodingResult.
     *
     * @return True if at least one dead decision was found, false otherwise.
     */
    public boolean printDeadDecisionValues() {
        boolean foundDeadDecision = false;

        if (this.checkSat()) {
            for (List<IntVar> vars : this.variables) {
                for (IntVar var : vars) {
                    if (var instanceof BoolVar) { //number decisions not regarded here
                        CpModel testModel = this.model.getClone();
                        testModel.addEquality(var, testModel.trueLiteral());
                        CpSolver solver = new CpSolver();
                        CpSolverStatus status = solver.solve(testModel);
                        if (status == CpSolverStatus.INFEASIBLE) {
                            foundDeadDecision = true;
                            System.out.println("Dead Decision Value: " + var.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Model is unsatisfiable!");
        }

        return foundDeadDecision;
    }

    /**
     * Identifies and prints false optional decisions (that can never be false) in the CpEncodingResult.
     *
     * @return True if at least one false optional decision was found, false otherwise.
     */
    public boolean printFalseOptionalDecisionValues() {
        boolean foundFalseOptionalDecision = false;

        if (this.checkSat()) {
            for (List<IntVar> vars : this.variables) {
                for (IntVar var : vars) {
                    if (var instanceof BoolVar) { //number decisions not regarded here
                        CpModel testModel = this.model.getClone();
                        testModel.addEquality(var, testModel.falseLiteral());
                        CpSolver solver = new CpSolver();
                        CpSolverStatus status = solver.solve(testModel);
                        if (status == CpSolverStatus.INFEASIBLE) {
                            foundFalseOptionalDecision = true;
                            System.out.println("False Optional Decision Value: " + var.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Model is unsatisfiable!");
        }

        return foundFalseOptionalDecision;
    }
}
