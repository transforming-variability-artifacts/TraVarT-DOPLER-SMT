package edu.kit.dopler.model;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());
        BooleanDecision decision1 = new BooleanDecision("Do you want to create an Onlineshop?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);


        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("DebitCard"));
            add(new EnumerationLiteral("CreditCard"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("Which payment methods should be supported??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,2);
        dopler.addDecision(decision2);

        BooleanDecision decision3 = new BooleanDecision("Should a search function be suppoted?","",new BooleanLiteralExpression(true), new HashSet<>());
        IExpression expressionDecision3 = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(false));

        Enumeration enumerationDecision6 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Orders"));
            add(new EnumerationLiteral("Security"));
            add(new EnumerationLiteral("Payments"));
            add(new EnumerationLiteral("Wishlist"));
        }});





        BooleanDecision decision4 = new BooleanDecision("Split products into categories?","",new BooleanLiteralExpression(true), new HashSet<>());


        BooleanDecision decision5 = new BooleanDecision("Should products be sortable?","",new BooleanLiteralExpression(true), new HashSet<>());

        dopler.addDecision(decision4);
        dopler.addDecision(decision5);

        EnumerationDecision decision6 = new EnumerationDecision("Which user management enhancements should be supported?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision6,1,4);
        dopler.addDecision(decision6);

        Rule rule1Decision3 = new Rule(expressionDecision3,new HashSet<>(){{
            add(new EnumEnforce(decision5, BooleanValue.getTrue()));
        }});

        IExpression expression2Decision3 = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(true));

        Rule rule2Decision3 = new Rule(expression2Decision3,new HashSet<>(){{
            add(new EnumEnforce(decision6, new StringValue("Security")));
        }});
        decision3.addRule(rule1Decision3);
        decision3.addRule(rule2Decision3);
        dopler.addDecision(decision3);

        Rule rule1Decision5 = new Rule(
                new Equals(new DecisionValueCallExpression(decision5),new BooleanLiteralExpression(false)),
                new HashSet<>(){{
                    add(new BooleanEnforce(decision3, BooleanValue.getTrue()));
                }});

        decision5.addRule(rule1Decision5);

        decision6.addRule(
                new Rule(
                        new NOT(new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Security"))),
                        new HashSet<>(){{
                            add(new Allows(decision6, new StringValue("Payments")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Security")),
                        new HashSet<>(){{
                            add(new DisAllows(decision6, new StringValue("Payments")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new NOT(new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Payments"))),
                        new HashSet<>(){{
                            add(new Allows(decision6, new StringValue("Security")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Payments")),
                        new HashSet<>(){{
                            add(new DisAllows(decision6, new StringValue("Security")));
                        }}
                )
        );




        dopler.toSMTStream().build().forEach(System.out::println);

        try {
            Stream.Builder<String> builder = dopler.toSMTStream();
            builder.add("(check-sat)");
            //builder.add("(get-model)");
            builder.add("(get-value (END_DECISION_0 DECISION_0_TAKEN_POST END_DECISION_1 DECISION_1_TAKEN_POST END_DECISION_2 DECISION_2_TAKEN_POST END_DECISION_3 DECISION_3_TAKEN_POST END_DECISION_4 DECISION_4_TAKEN_POST  END_DECISION_5 DECISION_5_TAKEN_POST ))");
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

    static boolean checkSat(Dopler dopler) throws Exception {
        Stream.Builder<String> builder = dopler.toSMTStream();
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

