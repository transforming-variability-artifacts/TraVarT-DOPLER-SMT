package edu.kit.dopler.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class BooleanDecision extends DecisionType<Boolean> {

    private final Range<Boolean> range;
    private AbstractValue<Boolean> value;


    public BooleanDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules) {
        super(question, description, visibilityCondition, taken, rules);
        range = new Range<>();
        range.add(BooleanValue.getFalse());
        range.add(BooleanValue.getTrue());
        value = BooleanValue.getFalse();
    }

    @Override
    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder) {

    }


    @Override
    public Range<Boolean> getRange() {
        return range;
    }

    @Override
    public void setRange(Range<Boolean> range) {
        /**
         * the Range of boolean can not be modified
         */
    }

    @Override
    public IValue<Boolean> getValue() {
        return value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = (Objects.requireNonNull(value)) ? BooleanValue.getTrue() : BooleanValue.getFalse();
        setSelected(value);
    }



}
