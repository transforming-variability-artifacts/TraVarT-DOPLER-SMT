package edu.kit.dopler.model;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


      Set<IDecision<?>> decisions = new HashSet<>();

      IExpression expression = new BooleanLiteralExpression(true);


      BooleanDecision decision = new BooleanDecision("test","test", expression,false, new HashSet<>());

      IExpression expression2 = new Equals(new DecisionValueCallExpression(decision), expression);
      BooleanDecision decision2 = new BooleanDecision("test","test", expression2,false, new HashSet<>());
      Set<IAction> actions = new HashSet<>();
      Enforce enforce = new BooleanEnforce(decision,BooleanValue.getFalse());
      actions.add(enforce);
      Rule rule = new Rule(expression,actions);
      Set<IAction> actions2 = new HashSet<>();
      Enforce enforce2 = new BooleanEnforce(decision,BooleanValue.getTrue());
      actions2.add(enforce2);
      Rule rule2 = new Rule(expression,actions2);
      decision2.addRule(rule);
      decision.addRule(rule2);
      decisions.add(decision);
      decisions.add(decision2);

      Dopler dopler = new Dopler(decisions, new HashSet<>(),new HashSet<>());


      dopler.toSMTStream().build().forEach(System.out::println);

        try {
            System.out.println(checkSat(dopler));
        } catch (Exception e) {
           System.out.println(e);
        }


    }

    static boolean checkSat(Dopler dopler) throws Exception {
        Stream.Builder<String> builder = dopler.toSMTStream();
        builder.add("(check-sat)");
       // builder.add("(get-model)");
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

