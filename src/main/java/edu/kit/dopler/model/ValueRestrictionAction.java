package edu.kit.dopler.model;

import java.util.stream.Stream;

public abstract class ValueRestrictionAction extends Action{

    private final IDecision<?> decision;


    public ValueRestrictionAction(IDecision<?> decision) {
        this.decision = decision;
    }


    public IDecision<?> getDecision() {
        return decision;
    }

    abstract void toSMTStream(Stream.Builder<String> builder);
}
