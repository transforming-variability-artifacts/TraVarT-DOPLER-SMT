/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 *    @author Johannes von Geisau
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.IntVar;
import com.google.ortools.sat.Literal;
import edu.kit.dopler.exceptions.ActionExecutionException;
import edu.kit.dopler.exceptions.EvaluationException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public abstract class Decision<T> implements IDecision<T> {

    private static int uid = 0;
    private final int id;
    private final Set<Rule> rules;
    private String displayId;
    private String question;
    private String description;
    private IExpression visibilityCondition;
    private boolean taken;
    private boolean select;
    private DecisionType decisionType;

    protected Decision(String displayId, String question, String description, IExpression visibilityCondition,
                       Set<Rule> rules, DecisionType decisionType) {
        this.id = uid++;
        this.displayId = displayId;
        this.question = question;
        this.description = description;
        this.visibilityCondition = visibilityCondition;
        this.taken = false;
        this.rules = rules;
        this.decisionType = decisionType;
    }

    @Override
    public String getDisplayId() {
        return displayId;
    }

    @Override
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    @Override
    public final boolean isSelected() {
        return select;
    }

    @Override
    public final void setSelected(final boolean select) {
        this.select = select;
        setTaken(true);
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
        for (Rule rule : rules) {
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

    /**
     * This methode adds the SMT Encoding of the decision to the builder
     *
     * @param builder   the Stream Builder for Building the SMT Encoding recursive
     * @param decisions all decisions of the DOPLER Model, which are needed for the
     *                  late mapping of the constants
     */
    @Override
    public void toSMTStream(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {
        // if the visibility condition is only a LiteralExpression (true, false) then
        // the ite should be left out because (ite true if else) is no valid syntax
        if (getVisibilityCondition() instanceof LiteralExpression) {

            toSMTStreamDecisionSpecific(builder, decisions);
            // if the decision has a literal expression (true or false) as visibility
            // condition we add the decision encoding
            // without ite visibility
        } else {
            builder.add("(ite ");
            getVisibilityCondition().toSMTStream(builder, toStringConstforSMT()); // if isVisible condition
            toSMTStreamDecisionSpecific(builder, decisions); // if part
            builder.add("(and "); // else
            mapPreToPostConstants(builder, decisions); // else
            setDefaultValueInSMT(builder);
            builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST " + "false" + ")"); // else
            builder.add(")"); // else
//				builder.add("(ite"); //else
//				builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST " + "true)"); // if condition
//				toSMTStreamDecisionSpecific(builder, decisions); // if part
//				// ite DECISION_1_TAKEN_POST  toSMTStreamDecisionSpecific(builder, decisions) else
//				builder.add("(and "); // else
//				mapPreToPostConstants(builder, decisions); // else
//				setDefaultValueInSMT(builder);
//				builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST " + "false" + ")"); // else
//				builder.add(")"); // else
//				builder.add(")");
            builder.add(")"); // closing the ite of the visibilityDecision
        }
    }

    @Override
    public void mapRulesToCP(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars, Map<IDecision<?>, List<Literal>> isTakenVars) {
        Literal decisionVisibleLiteral = this.visibilityCondition.toCPLiteral(model, cpVars);

        for (Rule rule : this.rules) {
            Literal ruleCondtionLiteral = rule.getCondition().toCPLiteral(model, cpVars);

            Literal l = model.newBoolVar("decisionVisible_AND_ruleCondition");
            // assure that: l <=> (decisionVisibleLiteral and ruleCondtionLiteral)
            // =>
            model.addImplication(l, decisionVisibleLiteral);
            model.addImplication(l, ruleCondtionLiteral);
            // <=
            model.addBoolOr(new Literal[]{decisionVisibleLiteral.not(), ruleCondtionLiteral.not(), l});

            for (IAction action : rule.getActions()) {
                action.executeAsCP(model, l, cpVars, isTakenVars);
            }

        }
    }

    protected Literal[] getEnforceStandardValueConditionLiterals(CpModel model, Map<IDecision<?>, List<IntVar>> cpVars, Map<IDecision<?>, List<Literal>> isTakenVars) {
        Literal decisionVisibleLiteral = this.getVisibilityCondition().toCPLiteral(model, cpVars);

        ArrayList<Literal> literals = new ArrayList<>(); //only enforce std value if dec is not visible (1) and was not enforced/taken by a rule-action (from another decision, of course) (2)

        literals.add(decisionVisibleLiteral.not()); //(1)

        if (isTakenVars.get(this).isEmpty()) { //(2)
            literals.add(model.trueLiteral());
        } else { //(2)
            BoolVar isTakenVar = model.newBoolVar("isTakenVar");

            //assure that: isTakenVar <=> or(isTakenVars)
            // "=>" as CNF
            model.addBoolOr(isTakenVars.get(this)).onlyEnforceIf(isTakenVar);

            // "<=" as CNF
            isTakenVars.get(this).forEach(var -> model.addBoolOr(new Literal[]{var.not(), isTakenVar}));


            literals.add(isTakenVar.not());
        }

        return literals.toArray(Literal[]::new);
    }

    /**
     * this methode encodes the rules of the decision to the SMT Encoding
     *
     * @param builder   the Stream Builder for Building the SMT Encoding recursive
     * @param decisions all decisions of the DOPLER Model, which are needed for the
     *                  late mapping of the constants
     */
    public void toSMTStreamRules(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {
        // for the smt encoding the decision is considered taken when the rules are
        // applied
        // this is why in the following the taken const is mapped to true
        if (getRules().isEmpty()) {
            builder.add("(and ");
            builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")");
            mapPreToPostConstants(builder, decisions);
            builder.add(")"); // closing and
        } else {
            builder.add("(and");
            builder.add("(= " + toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")");
            for (Rule rule : getRules()) {

                // if the condition is only a LiteralExpression (true, false) then the ite
                // should be left out because (ite true if else) is no valid syntax
                if (rule.getCondition() instanceof LiteralExpression) {

                    try {
                        if (rule.getCondition().evaluate()) {
                            toSMTStreamActionsPerRule(builder, rule, decisions);
                        } else {
                            mapPreToPostConstants(builder, decisions);
                        }
                    } catch (EvaluationException e) {
                        throw new RuntimeException(e);
                    }
                } else {

                    builder.add("(ite ");
                    rule.getCondition().toSMTStream(builder, toStringConstforSMT()); // if condition
                    toSMTStreamActionsPerRule(builder, rule, decisions); // if part
                    mapPreToPostConstants(builder, decisions);// else part
                    builder.add(")"); // closing the ite
                }
            }
            builder.add(")"); // closing and
        }
    }

    /**
     *
     * Encodes the actions for the rule Therefor the smt encoding is (and action1
     * action2 ...)
     */
    void toSMTStreamActionsPerRule(Stream.Builder<String> builder, Rule rule, Set<? super IDecision<?>> decisions) {
        builder.add("(and ");
        for (IAction action : rule.getActions()) {
            action.toSMTStream(builder, toStringConstforSMT());
        }
        mapPreToPostConstants(builder, decisions);
        builder.add(")"); // closing and
    }

    void toSMTStreamDecisionSpecific(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {
        toSMTStreamRules(builder, decisions);
    }

    /**
     * maps alle the pre constants to the post constants by adding (and (= pre post)
     * (= pre post)....) to the smt encoding
     *
     */
    void mapPreToPostConstants(Stream.Builder<String> builder, Set<? super IDecision<?>> decisions) {
        builder.add("(and ");
        for (Object decision : decisions) {
            IDecision<?> decision1 = (IDecision<?>) decision;
            if (decision1.getDecisionType() == DecisionType.ENUM) {
                EnumerationDecision enumerationDecision = (EnumerationDecision) decision1;
                for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration()
                        .getEnumerationLiterals()) {
                    builder.add("(= ");
                    builder.add(toStringConstforSMT() + "_" + decision1.toStringConstforSMT() + "_"
                            + enumerationLiteral.getValue() + "_PRE");
                    builder.add(toStringConstforSMT() + "_" + decision1.toStringConstforSMT() + "_"
                            + enumerationLiteral.getValue() + "_POST");
                    builder.add(")"); // closing =
                }
            } else {
                builder.add("(= ");
                builder.add(toStringConstforSMT() + "_" + decision1.toStringConstforSMT() + "_PRE");
                builder.add(toStringConstforSMT() + "_" + decision1.toStringConstforSMT() + "_POST");
                builder.add(")"); // closing =
            }

        }

        builder.add(")"); // closing and

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Decision<?> decision = (Decision<?>) o;
        return Objects.equals(this.displayId, decision.displayId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.displayId);
    }

    @Override
    public boolean isTaken() {
        return taken;
    }

    @Override
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String toStringConstforSMT() {
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

    @Override
    public String toString() {
        return displayId;
    }

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
}