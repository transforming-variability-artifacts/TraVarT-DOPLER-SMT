package edu.kit.dopler.model;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        Set<IDecision<?>> decisions = new HashSet<>();

        IExpression expression = new BooleanLiteralExpression(true);

        BooleanDecision decision = new BooleanDecision("1","test","test", expression,false, new HashSet<>());
        BooleanDecision decision2 = new BooleanDecision("2","test","test", expression,false, new HashSet<>());
        Set<IAction> actions = new HashSet<>();
        Enforce enforce = new BooleanEnforce(decision2,BooleanValue.getTrue());
        actions.add(enforce);
        Rule rule = new Rule(expression,actions);
        decision2.addRule(rule);
        decisions.add(decision);
        decisions.add(decision2);

        Dopler dopler = new Dopler(decisions, new HashSet<>(),new HashSet<>());


        dopler.toSMTStream().forEach(System.out::println);

    }

}
