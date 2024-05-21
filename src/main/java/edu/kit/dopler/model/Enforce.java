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
    void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(= " +  "POST_" + getDecision().toStringConstforSMT() + " " + value.toString());
    }

    public IValue<?> getValue() {
        return value;
    }
}
