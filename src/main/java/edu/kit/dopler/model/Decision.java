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

    public Decision(String question, String description, IExpression visibilityCondition, Set<Rule> rules, DecisionType decisionType) {
        this.id = uid++;
        this.question = question;
        this.description = description;
        this.visibilityCondition = visibilityCondition;
        this.taken = false;
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
        //builder.add("(ite ");
        //builder.add("(= " + toStringConstforSMT() + "_TAKEN_PRE" + " " + "false" + ")");
        // if part
        if(getVisibilityCondition() instanceof LiteralExpression){
            try {
                if(getVisibilityCondition().evaluate()){
                    toSMTStreamDecisionSpecific(builder, numberDecisions);

                }else{
                    builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST"+ " " + "false" + ")");
                }
            } catch (EvaluationException e) {
                throw new RuntimeException(e);
            }
        }else {
            builder.add("(ite ");
            getVisibilityCondition().toSMTStream(builder, toStringConstforSMT()); //if isVisible condition
            toSMTStreamDecisionSpecific(builder, numberDecisions);   //if part

            builder.add("(and "); //else
            mapPreToPostConstants(builder, numberDecisions);      //else
            builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST " + "false" + ")"); //else
            builder.add(")"); //else
            builder.add(")"); //closing the ite of the visibilityDecision
        }
       // mapPreToPostConstants(builder, numberDecisions);  //else of IsTaken
        //builder.add(")"); // closing the ite
    }

    void toSMTStreamRules(Stream.Builder<String> builder, int numberDecisions){

        if(getRules().isEmpty()){
            builder.add("(and ");
            builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST" + " " + "true" +  ")");
            mapPreToPostConstants(builder, numberDecisions);
            builder.add(")");
        }else {
            builder.add("(and");
            builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")");
            for (Rule rule : getRules()) {

                if (rule.getCondition() instanceof LiteralExpression) {

                    try {
                        if (rule.getCondition().evaluate()) {
                            System.out.println(getQuestion());
                            toSMTStreamActionsPerRule(builder, rule, numberDecisions);
                        } else {
                            mapPreToPostConstants(builder, numberDecisions);
                        }
                    } catch (EvaluationException e) {
                        throw new RuntimeException(e);
                    }
                } else {

                    builder.add("(ite ");
                    rule.getCondition().toSMTStream(builder, toStringConstforSMT()); // if condition
                    toSMTStreamActionsPerRule(builder, rule, numberDecisions);
                    mapPreToPostConstants(builder, numberDecisions);// else part
                    builder.add(")");
                }
            }
            builder.add(")");
        }
    }

    void toSMTStreamActionsPerRule(Stream.Builder<String> builder,Rule rule, int numberDecisions) {
        builder.add("(and ");
        for (IAction action : rule.getActions()) {
            action.toSMTStream(builder, toStringConstforSMT());
        }
        mapPreToPostConstants(builder, numberDecisions);
        builder.add(")");
    }
    abstract void toSMTStreamValidityConditions(Stream.Builder<String> builder, int numberDecisions);

    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder, int numberDecisions){

        if(getDecisionType() == DecisionType.NUMBER || getDecisionType() == DecisionType.STRING){

            toSMTStreamValidityConditions(builder, numberDecisions);

        }else{
            toSMTStreamRules(builder, numberDecisions);
        }


    }


    void mapPreToPostConstants(Stream.Builder<String> builder, int numberDecisions){
        builder.add("(and ");
        for (int i = 0; i < numberDecisions; i++) {
            builder.add("(= ");
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