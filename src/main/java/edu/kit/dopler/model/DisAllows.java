package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

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
            switch (getDecision().getDecisionType()){
                case ENUM:
                    EnumerationDecision decision = (EnumerationDecision) getDecision();
                    decision.addDissallowed(new EnumerationLiteral((String) disAllowValue.getValue()));
                    // if the new dissallowed Value is set, then the decision gets reset to the default value and das not taken
                    if (decision.getValue().getValue() == disAllowValue.getValue()){
                        decision.setTaken(false);
                        decision.setValue(new StringValue(decision.getStandardValue()));
                    }
            /**
                case BOOLEAN:
                    BooleanDecision decision1 = (BooleanDecision) getDecision();
                    IValue<Boolean> booleanIValue = (boolean) disAllowValue.getValue() ? BooleanValue.getFalse(): BooleanValue.getTrue();
                    decision1.setValue(booleanIValue);
                case STRING:
                    ValueDecision<?> decision2 = (ValueDecision<?>) getDecision();
                    Set<IExpression> conditions = decision2.getValidityConditions();
                    IExpression expression = new Equals(new DecisionValueCallExpression(getDecision()), new StringLiteralExpression(disAllowValue.getValue().toString()));
                    conditions.add(expression);
                    decision2.setValidityConditions(conditions);
                case NUMBER:
                    ValueDecision<?> decision3 = (ValueDecision<?>) getDecision();
                    Set<IExpression> conditions2 = decision3.getValidityConditions();
                    IExpression expression2 = new Equals(new DecisionValueCallExpression(getDecision()), new DoubleLiteralExpression((double) disAllowValue.getValue()));
                    conditions2.add(expression2);
                    decision3.setValidityConditions(conditions2);

            **/
                default:
                    throw new ActionExecutionException("Action only possible for EnumDecisions");
            }
        }catch (Exception e){
            throw new ActionExecutionException(e);
        }

    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String selectedDecisionString) {
        builder.add("(distinct ");
        builder.add( selectedDecisionString + "_" + getDecision().toStringConstforSMT() +  "_POST");
        builder.add(disAllowValue.getValue().toString());
        builder.add(")");
    }
}
