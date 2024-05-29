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
        builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_PRE" + " " + value.getValue().toString()  +  ")");
        builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_POST" + " " + value.getValue().toString() + ")");
    }

    public IValue<?> getValue() {
        return value;
    }
}
