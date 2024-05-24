package edu.kit.dopler.model;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


      Set<IDecision<?>> decisions = new HashSet<>();

      IExpression expression = new BooleanLiteralExpression(true);

      BooleanDecision decision = new BooleanDecision("1","test","test", expression,false, new HashSet<>());
      BooleanDecision decision2 = new BooleanDecision("2","test","test", expression,false, new HashSet<>());
      Set<IAction> actions = new HashSet<>();
      /**Enforce enforce = new BooleanEnforce(decision2,BooleanValue.getTrue());
      actions.add(enforce);
      Rule rule = new Rule(expression,actions);
      decision2.addRule(rule);
      **/decisions.add(decision);
      decisions.add(decision2);

      Dopler dopler = new Dopler(decisions, new HashSet<>(),new HashSet<>());


      dopler.toSMTStream().forEach(System.out::println);

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

            dopler.toSMTStream().forEach((a)-> {
                try {
                    writer.write(a);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
            writer.close();

            Scanner scanner = new Scanner(stdout);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }


        }catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


    }

}

/**
 *
 */