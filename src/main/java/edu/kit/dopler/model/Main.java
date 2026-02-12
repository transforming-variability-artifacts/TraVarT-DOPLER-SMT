/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Fabian Eger
 * 	@author Kevin Feichtinger
 *  @author David Kowal
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;


import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;



import static edu.kit.dopler.common.DoplerUtils.readDOPLERModelFromFile;
import static edu.kit.dopler.common.SolverUtils.*;

public class Main {

	public static void main(final String[] args) throws NotSupportedVariabilityTypeException, IOException {
        // Parse CLI arguments (help and z3 path)
        CliOptions opts;
        try {
            opts = parseArgs(args);
        } catch (IllegalArgumentException ex) {
            System.err.println("Error: " + ex.getMessage());
            printUsage();
            return;
        }

        if (opts.help) {
            printUsage();
            return;
        }

        // Z3 path: CLI > ENV > PATH default
        String z3Path = opts.z3Path != null && !opts.z3Path.isBlank() ? opts.z3Path : System.getenv("Z3_PATH");
        if (z3Path != null && !z3Path.isBlank()) {
            setZ3Path(z3Path);
            System.out.println("Using Z3 at: " + z3Path);
        } else {
            System.out.println("No Z3 path provided. Falling back to 'z3' from PATH. Use --help for options.");
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

        Dopler dopler = readDOPLERModelFromFile( Paths.get(System.getProperty("user.home") + "/DOPLER-models/CSVModels/ArtefactsAndAssets.csv"));
        dopler.toSMTStream().build().forEach(System.out::println);
        //anomalieAnalysisOfAllModels();
	}

    private static void printUsage() {
        System.out.println("Usage: java -jar smt_dopler-2.0.0.jar [options] [Z3_PATH]\n"
                + "\n"
                + "Options:\n"
                + "  -h, --help           Show this help and exit\n"
                + "  -z PATH              Path to the z3 executable\n"
                + "  --z3=PATH            Path to the z3 executable (alternative form)\n"
                + "\n"
                + "Arguments:\n"
                + "  Z3_PATH              Positional path to z3 (alternative to -z/--z3)\n"
                + "\n"
                + "Environment:\n"
                + "  Z3_PATH              If set, used when no CLI path is provided\n");
    }

    private static CliOptions parseArgs(String[] args) {
        CliOptions opts = new CliOptions();
        if (args == null) return opts;
        for (int i = 0; i < args.length; i++) {
            String a = args[i];
            if (a == null || a.isBlank()) continue;
            if ("-h".equals(a) || "--help".equals(a) || "-?".equals(a) || "help".equalsIgnoreCase(a)) {
                opts.help = true;
            } else if (a.startsWith("--z3=")) {
                opts.z3Path = a.substring("--z3=".length());
            } else if ("--z3".equals(a) || "-z".equals(a)) {
                if (i + 1 >= args.length) {
                    throw new IllegalArgumentException("Missing value for " + a);
                }
                opts.z3Path = args[++i];
            } else if (a.startsWith("-")) {
                throw new IllegalArgumentException("Unknown option: " + a);
            } else {
                // Positional Z3 path if not yet set
                if (opts.z3Path == null || opts.z3Path.isBlank()) {
                    opts.z3Path = a;
                } else {
                    // Ignore extra positionals for now; could extend later if needed
                }
            }
        }
        return opts;
    }

    private static class CliOptions {
        boolean help;
        String z3Path;
    }


    static void anomalieAnalysisOfAllModels() {

        Path startDirectory = Paths.get(System.getProperty("user.home") + "/DOPLER-models/CSVModles/");


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
                System.out.println(dopler.toSMTStream());
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
