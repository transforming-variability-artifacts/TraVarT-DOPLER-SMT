package edu.kit.dopler.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class NumberDecision extends ValueDecision<Double>{

    private Range<Double> range;
    private AbstractValue<Double> value;

    public NumberDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules, Set<IExpression> validityConditions) {
        super(question, description, visibilityCondition, taken, rules, validityConditions, DecisionType.NUMBER);
        range = new Range<>();
        value = new DoubleValue(Double.NaN);
    }

    @Override
    void toSMTStreamValueDecisionSpecific(Stream.Builder<String> builder) {

    }

    @Override
    public Range<Double> getRange() {
        return range;
    }

    @Override
    public void setRange(Range<Double> range) {
        this.range = range;
    }


    @Override
    public IValue<Double> getValue() {
        return value;
    }

    @Override
    public void setValue(Double value) {
        Double v = Objects.requireNonNull(value);
        if(checkInRange(v)){
            this.value = new DoubleValue(value);
        }


    }

    private boolean checkInRange(Double value){
        return true;
    }


}
