package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class NumberDecision extends ValueDecision<Double>{

    private AbstractValue<Double> value;

    public NumberDecision( String id, String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(id, question, description, visibilityCondition, taken, rules, validityConditions, DecisionType.NUMBER);
        value = new DoubleValue(-1.0);
    }

    @Override
    void toSMTStreamValueDecisionSpecific(Stream.Builder<String> builder) {

    }


    @Override
    public IValue<Double> getStandardValue() {
        return new DoubleValue(-1.0);
    }

    @Override
    public IValue<Double> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<Double> value) throws ValidityConditionException {
        Double v = Objects.requireNonNull(value.getValue());
        this.value.setValue(v);
        if(checkValidity()){
            setSelected(true);
        } else {
            this.value.setValue(getStandardValue().getValue());
            throw new ValidityConditionException("Value: " + v + "does not fullfil validity condition");
        }

    }




}
