package edu.kit.dopler.common;


import edu.kit.dopler.model.Dopler;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public final class SolverUtils {

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
        final Scanner scanner = satSolver(stream,true);
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
        Stream.Builder<String> builder = dopler.toSMTStream();
        checkForDeadDecision(dopler, builder);
        builder = dopler.toSMTStream();
        checkForFalseOptionalDecisions(dopler,builder);

    }
    private static void checkForFalseOptionalDecisions(final Dopler doplerModel, Stream.Builder<String> builder){
        builder.add("(check-sat)");
        builder.add("(get-model)");


        final Stream<String> stream = builder.build();
        final Scanner scanner = satSolver(stream,true);


        while (true) {
            builder = doplerModel.toSMTStream();
            assert scanner != null;
            if (!scanner.hasNextLine()) break;

            final String line = scanner.nextLine();
            if (line.equals("unsat")) {
                System.out.println("Void DM");
                return;
            } else if(line.contains("(define-fun END")){
                String[] newLine = line.split("\\s+");
                String nextLine = scanner.nextLine();
                builder.add("(assert (= " + newLine[2]+ " " + "false" + "))");
                builder.add("(check-sat)");
                builder.add("(get-model)");
                final Stream<String> deadDecisionStream = builder.build();
                final Scanner scannerDeadDecision = satSolver(deadDecisionStream,true);
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

    private static void checkForDeadDecision(final Dopler doplerModel, Stream.Builder<String> builder){
        builder.add("(check-sat)");
        builder.add("(get-model)");


        final Stream<String> stream = builder.build();
        final Scanner scanner = satSolver(stream,true);


        while (true) {
            builder = doplerModel.toSMTStream();
            assert scanner != null;
            if (!scanner.hasNextLine()) break;

            final String line = scanner.nextLine();
            if (line.equals("unsat")) {
                System.out.println("Void DM");
                return;
            } else if(line.contains("(define-fun END")){
                String[] newLine = line.split("\\s+");
                String nextLine = scanner.nextLine();
                //System.out.println("Check for Feature: " +  newLine[2]);
                builder.add("(assert (= " + newLine[2]+ " " + "true" + "))");
                builder.add("(check-sat)");
                builder.add("(get-model)");
                final Stream<String> deadDecisionStream = builder.build();

                final Scanner scannerDeadDecision = satSolver(deadDecisionStream,true);
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
        final boolean isSAT = true;
        String asserts = "";


        do {
            builder.add(asserts);
            //builder.add("(minimize (+ (ite DECISION_0_TAKEN_POST 1 0) (ite DECISION_1_TAKEN_POST 1 0) ) )")
            builder.add("(check-sat)");
            builder.add("(get-model)");

            final Stream<String> stream = builder.build();
            final Scanner scanner = satSolver(stream,true);
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

                } else if(line.contains("(define-fun")){
                    String[] newLine = line.split("\\s+");
                    String nextLine = scanner.nextLine();
                    String[] value = nextLine.split("\\)");
                    //System.out.println(newLine[2]);
                    asserts += "(= " + newLine[2]+ " " + value[0] + ")";
                }
            }
            asserts += ")))";
        } while (true);

    }



    private static int getAmountOfConfigs(final Dopler dopler, Stream.Builder<String> builder) {
        int amount = 0;
        final boolean isSAT = true;
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
            final Scanner scanner = satSolver(stream,true);
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
    static Scanner satSolver(final Stream<String> stream, boolean smt2) {
        final String[] command;
        if (smt2) {
            command = new String[]{"../z3/build/z3", "-in", "-smt2"};
        }else{
            command = new String[]{"../z3/build/z3"};
        }


        final ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(command);
        Process process;
        try {
            process = processBuilder.start();

            final OutputStream stdout = process.getOutputStream();
            final InputStream stdin = process.getInputStream();

            final BufferedReader reader = new BufferedReader(new InputStreamReader(stdin));
            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdout));

            stream.forEach(a -> {
                try {
                    writer.write(a);
                    writer.newLine();
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
            writer.close();
            final Scanner scanner = new Scanner(stdin);

            return scanner;
        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }
}
