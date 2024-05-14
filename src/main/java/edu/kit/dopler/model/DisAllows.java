package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public class DisAllows extends ValueRestrictionAction{

    AbstractValue disAllowValue;

    public DisAllows(IDecision decisionType, AbstractValue disAllowValue) {
        super(decisionType);
        this.disAllowValue = disAllowValue;
    }

    @Override
    public void execute()  throws ActionExecutionException {
        try {
            Range range = getDecisionType().getRange();
            if(range.contains(disAllowValue)){
                range.remove(disAllowValue);
                getDecisionType().setRange(range);
            }else{
                throw new ActionExecutionException("disAllowValue: " + disAllowValue + " not in Range of Decision ( " + range.toString() + ")");
            }
        }catch (Exception e){
            throw new ActionExecutionException(e);
        }

    }

    @Override
    void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(distinct ");
        builder.add("POST_" + getDecisionType().toStringConstforSMT());
        builder.add(disAllowValue.toString());
        builder.add(")");
    }
}
