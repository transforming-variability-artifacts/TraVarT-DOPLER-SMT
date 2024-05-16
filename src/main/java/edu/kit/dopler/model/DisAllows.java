package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public class DisAllows extends ValueRestrictionAction{

    IValue<?> disAllowValue;

    public DisAllows(IDecision<?> decisionType, IValue<?> disAllowValue) {
        super(decisionType);
        this.disAllowValue = disAllowValue;
    }

    @Override
    public void execute()  throws ActionExecutionException {
        try {
            Range range = getDecision().getRange();
            if(range.contains(disAllowValue)){
                range.remove(disAllowValue);
                getDecision().setRange(range);
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
        builder.add("POST_" + getDecision().toStringConstforSMT());
        builder.add(disAllowValue.toString());
        builder.add(")");
    }
}
