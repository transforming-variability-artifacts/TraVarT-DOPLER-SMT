package edu.kit.dopler.common;

import de.ovgu.featureide.fm.core.JavaLogger;
import de.ovgu.featureide.fm.core.Logger;
import de.ovgu.featureide.fm.core.analysis.cnf.LiteralSet;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.analysis.cnf.generator.configuration.AllConfigurationGenerator;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.impl.CoreFactoryWorkspaceLoader;
import de.ovgu.featureide.fm.core.base.impl.DefaultFeatureModelFactory;
import de.ovgu.featureide.fm.core.base.impl.FMFactoryManager;
import de.ovgu.featureide.fm.core.base.impl.MultiFeatureModelFactory;
import de.ovgu.featureide.fm.core.cli.CLIFunctionManager;
import de.ovgu.featureide.fm.core.cli.ConfigurationGenerator;
import de.ovgu.featureide.fm.core.io.FileSystem;
import de.ovgu.featureide.fm.core.io.JavaFileSystem;
import de.ovgu.featureide.fm.core.io.uvl.UVLFeatureModelFormat;
import de.ovgu.featureide.fm.core.job.LongRunningCore;
import de.ovgu.featureide.fm.core.job.LongRunningWrapper;
import edu.kit.dopler.model.Dopler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
        final Scanner scanner = satSolver(stream);
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

    public static int getFeatureIDConfigs(Path filePath) throws IOException {
        FileSystem.INSTANCE = new JavaFileSystem();
        LongRunningWrapper.INSTANCE = new LongRunningCore();
        Logger.logger = new JavaLogger();

        FMFactoryManager.getInstance().addExtension(DefaultFeatureModelFactory.getInstance());
        FMFactoryManager.getInstance().addExtension(MultiFeatureModelFactory.getInstance());
        FMFactoryManager.getInstance().setWorkspaceLoader(new CoreFactoryWorkspaceLoader());

        CLIFunctionManager.getInstance().addExtension(new ConfigurationGenerator());

        String content = Files.readString(filePath);
        IFeatureModel featureIdeFm = new MultiFeatureModelFactory().create();
        UVLFeatureModelFormat format = new UVLFeatureModelFormat();
        format.read(featureIdeFm, content);

        FeatureModelFormula formula = new FeatureModelFormula(featureIdeFm);
        List<LiteralSet> configs = LongRunningWrapper.runMethod(new AllConfigurationGenerator(formula.getCNF()));
        return configs.size();

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
        final Scanner scanner = satSolver(stream);


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
                final Scanner scannerDeadDecision = satSolver(deadDecisionStream);
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
        final Scanner scanner = satSolver(stream);


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

                final Scanner scannerDeadDecision = satSolver(deadDecisionStream);
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
            final Scanner scanner = satSolver(stream);
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
            final Scanner scanner = satSolver(stream);
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
    static Scanner satSolver(final Stream<String> stream) {

        final String[] command = { "/Documents/z3/z3/build/z3", "-in", "-smt2" };

        final ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("../z3/build/z3", "-in", "-smt2");
        Process process;
        try {
            process = processBuilder.start();

            final OutputStream stdin = process.getOutputStream(); // <- Eh?
            final InputStream stdout = process.getInputStream();

            final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

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
            final Scanner scanner = new Scanner(stdout);

            return scanner;
        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }


    /**
     * Starts a Process of the local Z3 Solver and feeds him the SMT Encoding Stream
     *
     * @param stream SMT Encoding
     * @return Output of the Solver
     */
    static Scanner satSolverWithoutSMT(final Stream<String> stream) {

        final String[] command = { "/Documents/z3/z3/build/z3"};

        final ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("../../z3/z3/build/z3");
        Process process;
        try {
            process = processBuilder.start();

            final OutputStream stdin = process.getOutputStream(); // <- Eh?
            final InputStream stdout = process.getInputStream();

            final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

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
            final Scanner scanner = new Scanner(stdout);

            return scanner;
        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }


}
