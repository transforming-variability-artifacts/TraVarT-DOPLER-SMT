package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;
import java.util.stream.Stream;

public class DisAllows extends ValueRestrictionAction{

    public static final String FUNCTION_NAME = "disAllow";
    
	IValue<?> disAllowValue;

    public DisAllows(IDecision<?> decisionType, IValue<?> disAllowValue) {
        super(decisionType);
        this.disAllowValue = disAllowValue;
    }



    @Override
    public void execute()  throws ActionExecutionException {

        if(getDecision().getDecisionType() == Decision.DecisionType.ENUM) {
            EnumerationDecision decision = (EnumerationDecision) getDecision();
            decision.addDissallowed(new EnumerationLiteral((String) disAllowValue.getValue()));

        }else {
            throw new ActionExecutionException("Action only possible for EnumDecisions");
        }


    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        builder.add("(distinct ");
        builder.add( selectedDecisionString + "_" + getDecision().toStringConstforSMT() + "_" + disAllowValue.getValue() +  "_POST");
        builder.add("true");
        builder.add(")");
    }
}
