package edu.kit.dopler.model;

import java.util.Set;
import java.util.stream.Stream;

public class EnumerationDecision extends DecisionType{


    private Enum enumeration;
    private int minCardinality;
    private int maxCardinaltiy;


    public EnumerationDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Enum enumeration, int minCardinality, int maxCardinaltiy) {
        super(question, description, visibilityCondition, taken, rules);
        this.enumeration = enumeration;
        this.minCardinality = minCardinality;
        this.maxCardinaltiy = maxCardinaltiy;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }
}
