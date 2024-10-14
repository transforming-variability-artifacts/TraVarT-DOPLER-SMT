package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.io.DecisionModelReader;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NotSupportedVariabilityTypeException, IOException {


        DecisionModelReader decisionModelReader = new DecisionModelReader();
        Dopler dopler = decisionModelReader.read(Path.of( System.getProperty("user.dir") +"/modelEval/product_chesspiece.csv"));
        Set<? super IDecision<?>> decisions = dopler.getDecisions();

        dopler.toSMTStream().build().forEach(System.out::println);
        try {
            Stream.Builder<String> builder = dopler.toSMTStream();

            System.out.println(getAmountOfConfigs(dopler));


            //builder.add("(assert (= DECISION_1_TAKEN_POST true))");
            builder.add("(check-sat)");
            dopler.createGetValueOFEndConstants(builder);
            //builder.add("(get-model)");
            //builder.add("(get-value (END_DECISION_0 DECISION_0_TAKEN_POST END_DECISION_1 DECISION_1_TAKEN_POST END_DECISION_2 DECISION_2_TAKEN_POST END_DECISION_3 DECISION_3_TAKEN_POST END_DECISION_4 DECISION_4_TAKEN_POST ))");
            builder.add("(exit)");
            Stream<String> stream = builder.build();
            Scanner scanner = satSolver(stream);
            if (scanner == null){
                throw new Exception();
            }
            while(scanner.hasNextLine()) {
               // System.out.println(scanner.nextLine());
            }

        } catch (Exception e) {
           System.out.println(e);
        }









    }


    /**
     * Gets the smt stream of the dopler model and adds the comment (check-sat) and then calls the satSolver with the stream
     * @param builder Stream Builder of the DOPLER MODEL which should be fed into the solver
     * @return True if the encoding is sat or false if the encoding is unsat
     * @throws Exception
     */
    static boolean checkSat(Stream.Builder<String> builder) throws Exception {

        // needs to be added to retrieve sat/unsat from the solver
        builder.add("(check-sat)");
        //builder.add("(get-model)");
        builder.add("(exit)");
        Stream<String> stream = builder.build();
        Scanner scanner = satSolver(stream);
        if (scanner == null){
            throw new Exception();
        }
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.equals("sat")){
                return true;
            }else if(line.equals("unsat")){
                return false;
            }
        }
        throw new Exception();
    }


    static int getAmountOfConfigs(Dopler dopler) {


        int amount = 0;
        boolean isSAT = true;
        String asserts = "";
        Stream.Builder<String> builder = dopler.toSMTStream();
       // builder.add("(assert (= DECISION_2_TAKEN_POST true))");
       // builder.add("(assert (= DECISION_0_TAKEN_POST true))");
      //  builder.add("(assert (= DECISION_1_TAKEN_POST true))");
        do{
            builder.add(asserts);
            builder.add("(check-sat)");
            dopler.createGetValueOFEndConstants(builder);
            Stream<String> stream = builder.build();
            Scanner scanner = satSolver(stream);
            builder = dopler.toSMTStream();

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.equals("unsat")){
                    return amount;
                }else if (line.equals("sat")){

                    asserts += "(assert (not (and";
                    amount++;

                } else if (line.equals(" ")) {

                }else{
                    System.out.println(line);
                    String [] result = line.split("[\\(\\)]");

                    if(result.length == 3) {

                        if (!result[2].contains("DECISION")) {
                            asserts += "(= " + result[1] + " (" + result[2] + "))";
                        } else {
                            asserts += "(= " + result[2] + ")";
                        }

                    }else if (result.length == 4){
                        asserts += "(= " + result[1] + " (" + result[2]  + "("  + result[3] + ")))";
                    }else {
                        asserts += "(= " +  result[1] + ")";
                    }
                }
            }
            asserts += ")))";

            System.out.println(amount);
        }while(true);

    }

    /**
     * Starts a Process of the local Z3 Solver and feeds him the SMT Encoding Stream
     * @param stream SMT Encoding
     * @return Output of the Solver
     */
    static Scanner satSolver(Stream<String> stream){

        String[] command = { "/Documents/z3/z3/build/z3","-in", "-smt2"};

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("../../Documents/z3/z3/build/z3","-in", "-smt2");
        Process process;
        try {
            process = processBuilder.start();

            OutputStream stdin = process.getOutputStream(); // <- Eh?
            InputStream stdout = process.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));


            stream.forEach((a)-> {
                try {
                    writer.write(a);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
            writer.close();
            Scanner scanner = new Scanner(stdout);

            return scanner;
        }catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }

}

