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


    // default Wert muss angenommen werden wenn der Wert davor gesetzt wurde und die decision wird wieder auf nicht getroffen gesetzt
    @Override
    public void execute()  throws ActionExecutionException {
        try {
            switch (getDecision().getDecisionType()){
                case ENUM:
                    EnumerationDecision decision = (EnumerationDecision) getDecision();
                    decision.addDissallowed(new EnumerationLiteral((String) disAllowValue.getValue()));
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
    void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(distinct ");
        builder.add("POST_" + getDecision().toStringConstforSMT());
        builder.add(disAllowValue.toString());
        builder.add(")");
    }
}
