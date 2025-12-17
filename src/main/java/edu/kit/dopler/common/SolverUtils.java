package edu.kit.dopler.common;


import com.google.ortools.sat.*;
import edu.kit.dopler.model.Dopler;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SolverUtils {

    // Path to the Z3 executable. Defaults to "z3" (resolved via PATH) but can be overridden at runtime.
    private static String z3Executable = "z3";

    /**
     * Configure the path to the Z3 binary (e.g., /usr/local/bin/z3 or C:\\z3\\bin\\z3.exe).
     * If not set, defaults to "z3" and relies on your PATH.
     */
    public static void setZ3Path(String path) {
        if (path != null && !path.isBlank()) {
            z3Executable = path;
        }
    }

    /**
     * Determines the satisfiability of a given constraint programming model.
     *
     * @param model The constraint programming model representing the DOPLER MODEL which should be fed into the solver.
     * @return True if the model is satisfiable (has feasible or optimal solutions), false otherwise.
     */
    public static boolean checkSat(CpModel model) {
        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);

        return status == CpSolverStatus.FEASIBLE || status == CpSolverStatus.OPTIMAL;
    }

    /**
     * Calculates the total number of configurations (solutions) for the given constraint programming model.
     * Note: This operation may take a significant amount of time for large models!
     *
     * @param model The constraint programming model representing the DOPLER MODEL which should be fed into the solver.
     * @return The total number of solutions found for the given model.
     */
    public static int getAmountOfConfigs(CpModel model) {
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
        solver.solve(model, counter);
        return counter.getSolutionCount();
    }

    /**
     * Solves the given constraint programming model and prints one satisfiable configuration, if available.
     *
     * @param model     The constraint programming model representing the DOPLER MODEL which should be fed into the solver.
     * @param variables A list of variables whose values will be printed if a solution is found.
     */
    public static void printOneConfig(CpModel model, List<IntVar> variables) {
        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);

        if (status == CpSolverStatus.OPTIMAL || status == CpSolverStatus.FEASIBLE) {
            System.out.printf("Solution found, time = %.2f s%n", solver.wallTime());
            for (IntVar var : variables) {
                System.out.printf("  %s = %d%n", var.getName(), solver.value(var));
            }
        } else {
            System.out.println("No solution found.");
        }
    }


    /**
     * Solves the given constraint programming model and prints all possible configurations.
     * Note: This operation may take a significant amount of time for large models!
     *
     * @param model     The constraint programming model representing the DOPLER MODEL which should be fed into the solver.
     * @param variables A list of variables whose values will be printed if a solution is found.
     */
    public static void printAllConfigs(CpModel model, List<IntVar> variables) {
        CpSolver solver = new CpSolver();

        // Local callback that prints each solution visited by the solver.
        class VarArraySolutionPrinter extends CpSolverSolutionCallback {
            private final List<IntVar> vars;
            private int solutionCount = 0;

            public VarArraySolutionPrinter(List<IntVar> vars) {
                this.vars = vars;
            }

            @Override
            public void onSolutionCallback() {
                System.out.printf("Solution #%d, time = %.2f s%n", solutionCount, wallTime());
                for (IntVar v : vars) {
                    System.out.printf("  %s = %d%n", v.getName(), value(v));
                }
                solutionCount++;
            }

            public int getSolutionCount() {
                return solutionCount;
            }
        }

        VarArraySolutionPrinter printer = new VarArraySolutionPrinter(variables);
        solver.getParameters().setEnumerateAllSolutions(true);
        solver.solve(model, printer);
        System.out.println("#solutions: " + printer.getSolutionCount());
    }

    /**
     * Gets the smt stream of the dopler model and adds the comment (check-sat) and
     * then calls the satSolver with the stream
     *
     * @param builder Stream Builder of the DOPLER MODEL which should be fed into
     *                the solver
     * @return True if the encoding is sat or false if the encoding is unsat
     * @throws Exception
     */
    public static boolean checkSat(final Stream.Builder<String> builder) throws Exception {

        // needs to be added to retrieve sat/unsat from the solver
        builder.add("(check-sat)");
        // builder.add("(get-model)");
        builder.add("(exit)");
        final Stream<String> stream = builder.build();
        final Scanner scanner = satSolver(stream, true);
        if (scanner == null) {
            throw new Exception();
        }
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (line.equals("sat")) {
                return true;
            }
            if (line.equals("unsat")) {
                return false;
            }
        }
        throw new Exception();
    }

    public static int getAmountOfConfigs(final Dopler dopler) {
        final int amount = getAmountOfConfigs(dopler, dopler.toSMTStream());
        System.out.println("SMT DOPLER variants: " + amount);
        return amount;
    }

    public static int getAmountOfConfigs(final Dopler dopler, final String asserts) {
        final Stream.Builder<String> builder = dopler.toSMTStream();
        builder.add(asserts);
        final int amount = getAmountOfConfigs(dopler, builder);
        System.out.println(amount);
        return amount;
    }

    static int getAmountOfConfigsUVLSMT(final String encoding, final String asserts) {
        final Stream.Builder<String> builder = Stream.builder();
        builder.add(encoding);
        //System.out.println(encoding);
        final int amount = getAmountOfConfigsUVLSMT(encoding, builder);
        System.out.println("UVL variants: " + amount);
        return amount;
    }

    public static void checkForAnomalies(final Dopler dopler) {

        checkForDeadDecisionValues(dopler);
        checkForFalseOptionalDecisionValues(dopler);

    }

    public static void checkForFalseOptionalDecisionValues(final Dopler dopler) {
        Stream.Builder<String> builder = dopler.toSMTStream();
        checkForFalseOptionalDecisions(dopler, builder);

    }

    public static void checkForDeadDecisionValues(final Dopler dopler) {
        Stream.Builder<String> builder = dopler.toSMTStream();
        checkForDeadDecision(dopler, builder);
    }

    private static void checkForFalseOptionalDecisions(final Dopler doplerModel, Stream.Builder<String> builder) {
        builder.add("(check-sat)");
        builder.add("(get-model)");


        final Stream<String> stream = builder.build();
        final Scanner scanner = satSolver(stream, true);


        while (true) {
            builder = doplerModel.toSMTStream();
            assert scanner != null;
            if (!scanner.hasNextLine()) break;

            final String line = scanner.nextLine();
            if (line.equals("unsat")) {
                System.out.println("Void DM");
                return;
            } else if (line.contains("(define-fun END")) {
                String[] newLine = line.split("\\s+");
                scanner.nextLine();
                builder.add("(assert (= " + newLine[2] + " " + "false" + "))");
                builder.add("(check-sat)");
                builder.add("(get-model)");
                final Stream<String> deadDecisionStream = builder.build();
                final Scanner scannerDeadDecision = satSolver(deadDecisionStream, true);
                while (scannerDeadDecision.hasNextLine()) {
                    final String deadDecisionLine = scannerDeadDecision.nextLine();
                    //System.out.println(deadDecisionLine);
                    if (deadDecisionLine.equals("unsat")) {
                        System.out.println("False Optional Decision Value: " + newLine[2]);
                        break;
                    } else if (deadDecisionLine.equals("sat")) {
                        break;
                    }

                }

            }
        }


    }

    private static void checkForDeadDecision(final Dopler doplerModel, Stream.Builder<String> builder) {
        builder.add("(check-sat)");
        builder.add("(get-model)");


        final Stream<String> stream = builder.build();

        final Scanner scanner = satSolver(stream, true);

        System.out.println(scanner.hasNextLine());

        while (true) {
            builder = doplerModel.toSMTStream();
            assert scanner != null;
            if (!scanner.hasNextLine()) break;

            final String line = scanner.nextLine();
            if (line.equals("unsat")) {
                System.out.println("Void DM");
                return;
            } else if (line.contains("(define-fun END")) {
                String[] newLine = line.split("\\s+");
                scanner.nextLine();
                //System.out.println("Check for Feature: " +  newLine[2]);
                builder.add("(assert (= " + newLine[2] + " " + "true" + "))");
                builder.add("(check-sat)");
                builder.add("(get-model)");
                final Stream<String> deadDecisionStream = builder.build();

                final Scanner scannerDeadDecision = satSolver(deadDecisionStream, true);
                while (scannerDeadDecision.hasNextLine()) {
                    final String deadDecisionLine = scannerDeadDecision.nextLine();
                    //System.out.println(deadDecisionLine);
                    if (deadDecisionLine.equals("unsat")) {
                        System.out.println("Dead Decision Value: " + newLine[2]);
                        break;
                    } else if (deadDecisionLine.equals("sat")) {

                    }


                }

            }
        }


    }


    private static int getAmountOfConfigsUVLSMT(final String encoding, Stream.Builder<String> builder) {
        int amount = 0;
        String asserts = "";


        do {
            builder.add(asserts);
            //builder.add("(minimize (+ (ite DECISION_0_TAKEN_POST 1 0) (ite DECISION_1_TAKEN_POST 1 0) ) )")
            builder.add("(check-sat)");
            builder.add("(get-model)");

            final Stream<String> stream = builder.build();
            final Scanner scanner = satSolver(stream, true);
            builder = Stream.builder();
            builder.add(encoding);

            while (scanner.hasNextLine()) {

                final String line = scanner.nextLine();
                if (line.equals("unsat")) {
                    return amount;
                }
                if (line.equals("sat")) {

                    asserts += "(assert (not (and";
                    amount++;
                    System.out.println(amount);

                } else if (line.equals(" ")) {

                } else if (line.contains("(define-fun")) {
                    String[] newLine = line.split("\\s+");
                    String nextLine = scanner.nextLine();
                    String[] value = nextLine.split("\\)");
                    //System.out.println(newLine[2]);
                    asserts += "(= " + newLine[2] + " " + value[0] + ")";
                }
            }
            asserts += ")))";
        } while (true);

    }


    private static int getAmountOfConfigs(final Dopler dopler, Stream.Builder<String> builder) {
        int amount = 0;
        String asserts = "";
        // builder.add("(assert (= DECISION_2_TAKEN_POST true))");
        // builder.add("(assert (= DECISION_0_TAKEN_POST true))");
        // builder.add("(assert (= DECISION_1_TAKEN_POST true))");
        do {
            builder.add(asserts);
            //builder.add("(minimize (+ (ite DECISION_0_TAKEN_POST 1 0) (ite DECISION_1_TAKEN_POST 1 0) ) )");
            builder.add("(check-sat)");

            dopler.createGetValueOFEndConstants(builder);
            final Stream<String> stream = builder.build();
            final Scanner scanner = satSolver(stream, true);
            builder = dopler.toSMTStream();

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                if (line.equals("unsat")) {
                    return amount;
                }
                if (line.equals("sat")) {

                    asserts += "(assert (not (and";
                    amount++;

                } else if (line.equals(" ")) {

                } else {
                    //System.out.println(line);
                    final String[] result = line.split("[\\(\\)]");

                    if (result.length == 3) {

                        if (!result[2].contains("DECISION")) {
                            asserts += "(= " + result[1] + " (" + result[2] + "))";
                        } else {
                            asserts += "(= " + result[2] + ")";
                        }

                    } else if (result.length == 4) {
                        asserts += "(= " + result[1] + " (" + result[2] + "(" + result[3] + ")))";
                    } else {
                        asserts += "(= " + result[1] + ")";
                    }
                }
            }
            asserts += ")))";

            //System.out.println(amount);
        } while (true);

    }

    /**
     * Starts a Process of the local Z3 Solver and feeds him the SMT Encoding Stream
     *
     * @param stream SMT Encoding
     * @return Output of the Solver
     */
    public static Scanner satSolver(final Stream<String> stream, boolean smt2) {
        final String[] command;

        File file = new File("encoding.smt2");


        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String input = stream.collect(Collectors.joining("\n"));
            writer.write(input);
            writer.close();
//           stream.forEach(a -> {
//                try {
//                    System.out.println(a);
//                    writer.write(a);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//           });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (smt2) {
            command = new String[]{z3Executable, "-smt2", "encoding.smt2"};
        } else {
            command = new String[]{z3Executable};
        }


        final ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);
        Process process;
        try {
            process = processBuilder.start();


            final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }

//
//            int exitCode = process.waitFor();
//            if (exitCode != 0) {
//                System.out.println("Z3 exited with code: " + exitCode);
//
//            }

            return new Scanner(reader);


        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        }
        return null;
    }
}
