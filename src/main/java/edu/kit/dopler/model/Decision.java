package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;
import edu.kit.dopler.exceptions.EvaluationException;

import java.util.Set;
import java.util.stream.Stream;

abstract class Decision<T> implements IDecision<T> {




    public enum DecisionType {
        BOOLEAN("Boolean"), NUMBER("Double"), STRING("String"), ENUM("Enumeration");

        private final String type;

        DecisionType(final String type) {
            this.type = type;
        }

        public boolean equalString(final String type) {
            return this.type.equals(type);
        }

        @Override
        public String toString() {
            return type;
        }
    }
    private static int uid = 0;
    private final int id;
    private String question;
    private String description;
    private IExpression visibilityCondition;
    private final Set<Rule> rules;
    private boolean taken;
    private boolean select;
    private DecisionType decisionType;

    public Decision(String question, String description, IExpression visibilityCondition, boolean taken, Set<Rule> rules,DecisionType decisionType) {
        this.id = uid++;
        this.question = question;
        this.description = description;
        this.visibilityCondition = visibilityCondition;
        this.taken = taken;
        this.rules = rules;
        this.decisionType = decisionType;
    }

    @Override
    public final void setSelected(final boolean select) {
        this.select = select;
        setTaken(true);
    }

    @Override
    public final boolean isSelected() {
        return select;
    }


    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Set<Rule> getRules() {
        return rules;
    }

    @Override
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public void removeRule(Rule rule) {
        rules.remove(rule);
    }

    @Override
    public void executeRules() throws ActionExecutionException, EvaluationException {
        for(Rule rule : rules){
           rule.executeActions();
        }
    }

    @Override
    public IExpression getVisibilityCondition() {
        return visibilityCondition;
    }

    @Override
    public void setVisibilityCondition(IExpression visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }

    public boolean isVisible() throws EvaluationException {
        return visibilityCondition.evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder,int numberDecisions) {
        builder.add("(ite");
        builder.add("(= " + toStringConstforSMT() + "_TAKEN " + "false" + ")");
        // if part
        if(getVisibilityCondition() instanceof LiteralExpression){
            try {
                if(getVisibilityCondition().evaluate()){

                    toSMTStreamDecisionSpecific(builder, numberDecisions);
                }
            } catch (EvaluationException e) {
                throw new RuntimeException(e);
            }
        }else {
            builder.add("(ite");
            getVisibilityCondition().toSMTStream(builder, toStringConstforSMT()); //if isVisible condition
            toSMTStreamDecisionSpecific(builder, numberDecisions);   //if part
            mapPreToPostConstants(builder, numberDecisions);      //else
            builder.add(")"); //closing the ite of the visibilityDecision
        }
        //else of IsTaken
        builder.add("(and");
        for (int i = 0; i < numberDecisions; i++) {
            builder.add("(=");
            builder.add(toStringConstforSMT() + "_DECISION_" + i + "_PRE");
            builder.add(toStringConstforSMT() + "_DECISION_" + i + "_POST");
            builder.add(")");
        }
        builder.add(")");
        builder.add(")"); // closing the ite
    }

    void toSMTStreamRules(Stream.Builder<String> builder){
        if(getRules().isEmpty()){
            builder.add("(= " + toStringConstforSMT() + "_TAKEN" + " " + "true" +  ")");
        }
        for(Rule rule: getRules()){
            if (rule.getCondition() instanceof LiteralExpression){
                try {
                    if(rule.getCondition().evaluate()){
                        builder.add("(and"); //if part
                        for (IAction action : rule.getActions()) {
                            action.toSMTStream(builder, toStringConstforSMT());
                        }
                        builder.add("(= " + toStringConstforSMT() + "_TAKEN" + " " + "true" +  ")");
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
                builder.add("(= " + toStringConstforSMT() + "_TAKEN" + " " + "true" +  ")");
                builder.add(")");
                // else part
                builder.add(")");
            }
        }
    }

    abstract void toSMTStreamValidityConditions(Stream.Builder<String> builder, int numberDecisions);

    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder, int numberDecisions){

        if(getDecisionType() == DecisionType.NUMBER || getDecisionType() == DecisionType.STRING){

            toSMTStreamValidityConditions(builder, numberDecisions);

        }else{
            toSMTStreamRules(builder);
        }




    }


    void mapPreToPostConstants(Stream.Builder<String> builder, int numberDecisions){
        builder.add("(and");
        for (int i = 0; i < numberDecisions; i++) {
            builder.add("(=");
            builder.add(toStringConstforSMT() + "_DECISION_" + i + "_PRE");
            builder.add(toStringConstforSMT() + "_DECISION_" + i + "_POST");
            builder.add(")");
        }
        builder.add(")");
    }


    @Override
    public boolean isTaken() {
        return taken;
    }

    @Override
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String toStringConstforSMT(){
        return "DECISION_" + id;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(DecisionType decisionType) {
        this.decisionType = decisionType;
    }

    public int getId() {
        return id;
    }
}