/**
 *
 * The concrete implementation of a boolean decision, which holds a boolean decision variable
 *
 */

package edu.kit.dopler.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class BooleanDecision extends Decision<Boolean> {

    private AbstractValue<Boolean> value;


    public BooleanDecision(String displayId, String question, String description, IExpression visibilityCondition, Set<Rule> rules) {
        super(displayId, question, description, visibilityCondition, rules, DecisionType.BOOLEAN);
        value = BooleanValue.getFalse();

    }


    @Override
    public Boolean getStandardValue() {
        return false;
    }

    @Override
    public IValue<Boolean> getValue() {
        return value;
    }

    @Override
    public void setValue(IValue<Boolean> value) {
        this.value = (Objects.requireNonNull(value.getValue())) ? BooleanValue.getTrue() : BooleanValue.getFalse();
        setSelected(value.getValue());
    }

    @Override
    public void setDefaultValueInSMT(Stream.Builder<String> builder) {
        builder.add("(= " + toStringConstforSMT() + "_" + toStringConstforSMT() + "_POST" + " " + getStandardValue() + ")");
    }


    @Override
    void toSMTStreamValidityConditions(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {

    }
}
