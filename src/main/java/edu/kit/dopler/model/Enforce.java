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
        builder.add("(and");
        //builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_PRE" +  value.getSMTValue().toString() +  ")");
        builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_POST" + " " + value.getSMTValue().toString()  + ")");
        builder.add("(= " + getDecision().toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that the decision also needs to be taken because of the encoding
        builder.add(")"); // closing and
    }

    public IValue<?> getValue() {
        return value;
    }
}
