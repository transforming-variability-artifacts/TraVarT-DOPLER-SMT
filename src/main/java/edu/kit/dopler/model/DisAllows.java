package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;
import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.Set;
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
            if(getDecision().getDecisionType() == Decision.DecisionType.ENUM) {
                EnumerationDecision decision = (EnumerationDecision) getDecision();
                decision.addDissallowed(new EnumerationLiteral((String) disAllowValue.getValue()));
                // if the new dissallowed Value is set, then the decision gets reset to the default value and as not taken
                if (decision.getValue().getValue() == disAllowValue.getValue()) {
                    decision.setTaken(false);
                    decision.setValue(new StringValue(decision.getStandardValue()));
                }
            }else {
                throw new ActionExecutionException("Action only possible for EnumDecisions");
            }

        } catch (ValidityConditionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        builder.add("(distinct ");
        builder.add( selectedDecisionString + "_" + getDecision().toStringConstforSMT() + "_" + disAllowValue.getValue() +  "_POST");
        builder.add("false");
        builder.add(")");
    }
}
