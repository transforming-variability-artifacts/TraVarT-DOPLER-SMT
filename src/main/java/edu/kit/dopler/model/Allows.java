package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public class Allows extends ValueRestrictionAction{


    private final IValue<?> allowedValue;

    public Allows(IDecision<?> decision, IValue<?> allowedValue) {
        super(decision);
        this.allowedValue = allowedValue;
    }

    @Override
    public void execute() throws ActionExecutionException {
        try {
            if(getDecision().getDecisionType() == Decision.DecisionType.ENUM){

                EnumerationDecision enumerationDecision = (EnumerationDecision) getDecision();
                EnumerationLiteral enumerationLiteral = new EnumerationLiteral((String) allowedValue.getValue());
                enumerationDecision.removeDissallowed(enumerationLiteral);

            }else {
                throw new ActionExecutionException("Action only possible for DecisionType Enum");
            }


        }catch(Exception e){
            throw new ActionExecutionException(e);
        }
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        // should not change anything in the SMT stream
        // solver already checks the whole range of the value
    }
}
