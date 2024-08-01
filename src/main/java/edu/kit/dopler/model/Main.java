package edu.kit.dopler.model;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>(),"");



        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Salami"));
            add(new EnumerationLiteral("Ham"));
            add(new EnumerationLiteral("Mozzarella"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("decision2", "Which Topping do you want on your pizza?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,3);
        dopler.addDecision(decision2);


        BooleanDecision decision1 = new BooleanDecision("decision1","Should the pizza have a cheesy crust?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);

        Enumeration enumerationDecision3 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Normal"));
            add(new EnumerationLiteral("Big"));
        }});
        EnumerationDecision decision3 = new EnumerationDecision("decision3","Which Size should the pizza have?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision3,1,1);
        dopler.addDecision(decision3);


        Enumeration enumerationDecision4 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Neapolitan"));
            add(new EnumerationLiteral("Sicilian"));
        }});
        EnumerationDecision decision4 = new EnumerationDecision("decision4","Which Dough do you prefer??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision4,1,1);
        dopler.addDecision(decision4);




        IExpression expressionDecision3 = new Equals(new DecisionValueCallExpression(decision3),new EnumeratorLiteralExpression(new EnumerationLiteral("Big")));

        Rule ruleDecision3 = new Rule(expressionDecision3,new HashSet<>(){{
            add(new EnumEnforce(decision4, new StringValue("Neapolitan")));
        }});
        decision3.addRule(ruleDecision3);

        IExpression expressionDecision4 = new Equals(new DecisionValueCallExpression(decision4),new EnumeratorLiteralExpression(new EnumerationLiteral("Sicilian")));

        Rule ruleDecision4 = new Rule(expressionDecision4,new HashSet<>(){{
            add(new BooleanEnforce(decision1, BooleanValue.getTrue()));
        }});
        decision4.addRule(ruleDecision4);



        IExpression expressionDecision1 = new Equals(new DecisionValueCallExpression(decision1),new BooleanLiteralExpression(true));

        Rule ruleDecision1 = new Rule(expressionDecision1,new HashSet<>(){{
            add(new EnumEnforce(decision3, new StringValue("Big")));
        }});
        decision1.addRule(ruleDecision1);

        dopler.toSMTStream().build().forEach(System.out::println);

        try {
            Stream.Builder<String> builder = dopler.toSMTStream();
            builder.add("(assert (= END_DECISION_3_Sicilian true))");
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
                System.out.println(scanner.nextLine());
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

