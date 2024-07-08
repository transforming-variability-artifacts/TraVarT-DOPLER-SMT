/**
 * Because the Enforce Action is possible with every decision type and the decision are generic
 * we needed to add an abstract enforce class to then specialise them into the different decision type enforces
 *
 */

package edu.kit.dopler.model;

import java.util.stream.Stream;

public abstract class Enforce extends ValueRestrictionAction{

    public static final String FUNCTION_NAME = "enforce";
    
	private final IValue<?> value;

    public Enforce(final IDecision<?> decision, final IValue<?> value) {
        super(decision);
        this.value = value;
    }



    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        builder.add("(and");
        if(getDecision().getDecisionType() == Decision.DecisionType.ENUM){

            builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() + "_" + value.getValue() +  "_POST" + " " + "true"  + ")");

        }else{
            //builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_PRE" +  value.getSMTValue().toString() +  ")");
            builder.add("(= " + selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_POST" + " " + value.getSMTValue().toString()  + ")");

        }
        builder.add("(= " + getDecision().toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that the decision also needs to be taken because of the encoding
        builder.add(")"); // closing and

    }

    public IValue<?> getValue() {
        return value;
    }
}
