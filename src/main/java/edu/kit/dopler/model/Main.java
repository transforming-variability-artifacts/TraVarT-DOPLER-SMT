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
 *    @author David Kowal
 *    @author Johannes von Geisau
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import com.google.ortools.Loader;
import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.CpSolver;
import com.google.ortools.sat.CpSolverStatus;
import com.google.ortools.sat.IntVar;
import edu.kit.dopler.common.VarArraySolutionPrinter;
import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.io.antlr.DoplerDecisionCreator;
import edu.kit.dopler.io.antlr.DoplerExpressionParser;
import edu.kit.dopler.io.antlr.resources.DoplerLexer;
import edu.kit.dopler.io.antlr.resources.DoplerParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static edu.kit.dopler.common.DoplerUtils.readDOPLERModelFromFile;
import static edu.kit.dopler.common.SolverUtils.*;

public class Main {

    public static void main(final String[] args) throws NotSupportedVariabilityTypeException, IOException {

        String fileName = "modelCSVs/AlwaysTrueTest.csv";
        CharStream input = CharStreams.fromFileName(fileName);
        DoplerLexer lexer = new DoplerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DoplerParser parser = new DoplerParser(tokens);
        ParseTree tree = parser.document();
        ParseTreeWalker walker = new ParseTreeWalker();
        DoplerDecisionCreator decisionCreator = new DoplerDecisionCreator(fileName);
        walker.walk(decisionCreator, tree);
        DoplerExpressionParser expressionParser = new DoplerExpressionParser(decisionCreator.getDopler());
        walker.walk(expressionParser, tree);
        Dopler dopler = expressionParser.getDopler();

        //Google OR CP solver:
        Loader.loadNativeLibraries();
        CpModel model = new CpModel();
        ArrayList<IntVar> variables = new ArrayList<>();

        //iterate over all decisions and create the variables and rules (two separate loops, because the rules can only be created if all decision variables exist!)
        dopler.decisions.forEach(decision -> {
            decision.createCPVariables(model, variables);
        });
        dopler.decisions.forEach(decision -> {
            decision.mapRulesToCP(model);
        });


        System.out.println("----------------------------------");
        // Create a solver and solve the model.
        boolean findAllSolutions = true;

        if (findAllSolutions) { //to get all solutions:

            CpSolver solver = new CpSolver();
            VarArraySolutionPrinter printer = new VarArraySolutionPrinter(variables);
            solver.getParameters().setEnumerateAllSolutions(true);

            CpSolverStatus status = solver.solve(model, printer);
            System.out.println("#solutions: " + printer.getSolutionCount());

        } else { //to get one solution:

            CpSolver solver = new CpSolver();
            CpSolverStatus status = solver.solve(model);

            if (status == CpSolverStatus.OPTIMAL || status == CpSolverStatus.FEASIBLE) {
                System.out.println("Found solution :)");
                for (IntVar var : variables) {
                    System.out.println(var.getName() + " = " + solver.value(var));
                }
            } else {
                System.out.println("No solution found.");
            }

        }


        /*System.out.println("\n\n--------------------------------"); //call z3 (SMT):
        System.out.println("--------------------------------");
        var smt = dopler.toSMTStream().build().collect(Collectors.joining("\n"));

        // Optional configuration
        java.util.HashMap<String, String> cfg = new java.util.HashMap<>();
        // e.g. cfg.put("model", "true");
        try (Context ctx = new Context(cfg)) {
            // Parse SMT-LIB2 string into Boolean expressions
            BoolExpr[] formulas = ctx.parseSMTLIB2String(
                    smt,
                    null, null,   // no custom sorts
                    null, null    // no pre-declared functions
            );

            Solver solverz = ctx.mkSolver();
            for (BoolExpr f : formulas) {
                solverz.add(f);
            }

            Status st = solverz.check();
            System.out.println("Result: " + st);
            if (st == Status.SATISFIABLE) {
                Model m = solverz.getModel();
                System.out.println("Model: " + m);
            }
        }*/
    }


    static void anomalieAnalysisOfAllModels() {

        Path startDirectory = Paths.get(System.getProperty("user.home") + "/work/VariabilityEval/BoolCSV/");


        try {

            Files.walk(startDirectory).filter(Files::isRegularFile).filter(path -> {
                String fileName = path.getFileName().toString().toLowerCase();
                return fileName.endsWith(".json") || fileName.endsWith(".csv");
            }).forEach(path -> {
                System.out.println(path.toString());
                Dopler dopler = null;
                try {
                    dopler = readDOPLERModelFromFile(path);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                long startTime = System.nanoTime();
                final Stream.Builder<String> builder = dopler.toSMTStream();
//                        try {
//                            System.out.println(checkSat(builder));
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000;
                System.out.println("SMT DOPLER Encoding needed: " + duration + "ms");

                startTime = System.nanoTime();
                // getAmountOfConfigs(dopler);
                checkForFalseOptionalDecisionValues(dopler);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("SMT DOPLER False Optional Anomalie needed: " + duration + "ms");  //divide by 1000000 to get milliseconds

                startTime = System.nanoTime();
                // getAmountOfConfigs(dopler);
                checkForDeadDecisionValues(dopler);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("SMT DOPLER Dead Anomalie needed: " + duration + "ms");  //divide by 1000000 to get milliseconds

                startTime = System.nanoTime();

                try {
                    checkSat(builder);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("SMT DOPLER one valid config needed: " + duration + "ms");  //divide by 1000000 to get milliseconds


            });
        } catch (IOException e) {

            System.err.println("Error reading file: " + e.getMessage());

        }

    }


}
