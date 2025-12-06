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
 *  @author David Kowal
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;


import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static edu.kit.dopler.common.DoplerUtils.readDOPLERModelFromFile;
import static edu.kit.dopler.common.SolverUtils.*;

public class Main {

    public static void main(final String[] args) throws NotSupportedVariabilityTypeException, IOException {
        // Configure Z3 path from CLI: first arg as absolute/relative path, or --z3=/path/to/z3
        String z3Path = null;
        if (args != null && args.length > 0) {
            if (args[0].startsWith("--z3=")) {
                z3Path = args[0].substring("--z3=".length());
            } else {
                z3Path = args[0];
            }
        } else {
            // Also allow environment variable fallback
            z3Path = System.getenv("Z3_PATH");
        }
        if (z3Path != null && !z3Path.isBlank()) {
            setZ3Path(z3Path);
            System.out.println("Using Z3 at: " + z3Path);
        } else {
            System.out.println("No Z3 path provided. Falling back to 'z3' from PATH.\n"
                    + "Usage: java -jar smt_dopler.jar <path-to-z3>\n"
                    + "   or: java -jar smt_dopler.jar --z3=/full/path/to/z3\n"
                    + "   or set env var Z3_PATH=/full/path/to/z3");
        }

//        Stream.Builder<String> builderString =  Stream.builder();
//        builderString.add("(assert (= true true)) (check-sat)");
//        try {
//            Scanner scanner = satSolver(builderString.build(),true);
//            System.out.println(scanner.hasNextLine());
//            System.out.println(scanner.nextLine());
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        anomalieAnalysisOfAllModels();
    }


    static void anomalieAnalysisOfAllModels() {

        Path startDirectory = Paths.get(System.getProperty("user.home") + "/work/VariabilityEval/BoolCSV/");


        try {

            Files.walk(startDirectory).filter(Files::isRegularFile)
                    .filter(path -> {
                        String fileName = path.getFileName().toString().toLowerCase();
                        return fileName.endsWith(".json") || fileName.endsWith(".csv");
                    })
                    .forEach(path -> {
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
