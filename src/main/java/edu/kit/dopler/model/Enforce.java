package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public abstract class Enforce extends ValueRestrictionAction{

    private final IValue<?> value;

    public Enforce(final IDecision<?> decision, final IValue<?> value) {
        super(decision);
        this.value = value;
    }



    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        builder.add("(= " +  "POST_"+ selectedDecisionString + "_" + getDecision().toStringConstforSMT() + " " + value.getValue().toString());
    }

    public IValue<?> getValue() {
        return value;
    }
}
