package edu.kit.dopler.model;

import java.util.stream.Stream;

public abstract class ValueRestrictionAction extends Action{

    private final IDecision decisionType;


    public ValueRestrictionAction(IDecision decisionType) {
        this.decisionType = decisionType;
    }


    public IDecision getDecisionType() {
        return decisionType;
    }

    abstract void toSMTStream(Stream.Builder<String> builder);
}
