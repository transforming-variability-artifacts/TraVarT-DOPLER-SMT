package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class BooleanDecision extends Decision<Boolean> {

    private AbstractValue<Boolean> value;


    public BooleanDecision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules) {
        super(question, description, visibilityCondition, taken, rules, DecisionType.BOOLEAN);
        value = BooleanValue.getFalse();

    }

    @Override
    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder) {

        if(getRules().isEmpty()){
            return;
        }
        for(Rule rule: getRules()){
            if (rule.getCondition() instanceof LiteralExpression){
                try {
                    if(rule.getCondition().evaluate()){
                        builder.add("(and"); //if part
                        for (IAction action : rule.getActions()) {
                            action.toSMTStream(builder, toStringConstforSMT());
                        }
                        builder.add(")");
                    }
                } catch (EvaluationException e) {
                    throw new RuntimeException(e);
                }
            }else {
                builder.add("(ite");
                rule.getCondition().toSMTStream(builder, toStringConstforSMT()); // if condition
                builder.add("(and"); //if part
                for (IAction action : rule.getActions()) {
                    action.toSMTStream(builder, toStringConstforSMT());
                }
                builder.add(")");
                // else part
                builder.add(")");
            }
        }



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



}
