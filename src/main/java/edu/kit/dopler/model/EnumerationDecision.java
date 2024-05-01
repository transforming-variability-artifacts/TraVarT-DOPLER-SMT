package edu.kit.dopler.model;

import java.util.Set;

public class EnumerationDecision extends DecisionType{


    private Enum enumeration;
    private int minCardinality;
    private int maxCardinaltiy;


    public EnumerationDecision(String question, String description, IExpression visibilityCondition, Enum enumeration, int minCardinality, int maxCardinaltiy) {
        super(question, description, visibilityCondition);
        this.enumeration = enumeration;
        this.minCardinality = minCardinality;
        this.maxCardinaltiy = maxCardinaltiy;
    }
}
