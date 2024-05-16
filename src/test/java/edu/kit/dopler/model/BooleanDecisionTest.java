package edu.kit.dopler.model;

import org.junit.Test;

import java.beans.Visibility;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BooleanDecisionTest {

    @Test
    public void setValueTest(){
        IValue<Boolean> value = BooleanValue.getTrue();
        IExpression expression = new BooleanLiteralExpression(true);
        BooleanDecision decision = new BooleanDecision("test","test", expression,false, Collections.emptySet());
        decision.setValue(value);
        assertTrue(decision.isTaken());
        assertSame(decision.getValue().getValue(), value.getValue());
    }

    @Test
    public void checkRangeValues(){
        IExpression expression = new BooleanLiteralExpression(true);
        BooleanDecision decision = new BooleanDecision("test","test", expression,false, Collections.emptySet());
        assertSame(decision.getRange().size(),2);
    }

    @Test
    public void testSetRange(){
        Range<Boolean> range = new Range();
        IExpression expression = new BooleanLiteralExpression(true);
        BooleanDecision decision = new BooleanDecision("test","test", expression,false, Collections.emptySet());
        assertThrows(UnsupportedOperationException.class,() -> decision.setRange(range));
    }

    @Test
    public void BooleanEnforceActionTest(){
        IValue<Boolean> value = BooleanValue.getTrue();
        IExpression expression = new BooleanLiteralExpression(true);
        BooleanDecision decision = new BooleanDecision("test","test", expression,false, new HashSet<>());
        BooleanDecision decision2 = new BooleanDecision("test","test", expression,false, new HashSet<>());

        assertFalse(decision2.isTaken());
        assertFalse(decision2.getValue().getValue());

        Rule rule = new Rule(expression,Collections.emptySet());
        Set<IAction> set = new HashSet<>();
        IAction action = new Enforce(decision2,BooleanValue.getTrue());
        set.add(action);
        rule.setActions(set);
        decision.addRule(rule);

        try {
            decision.executeRules();

        }catch (Exception e){
            System.out.println(e);
        }

        assertTrue(decision2.isTaken());
        assertTrue(decision2.getValue().getValue());

    }




}
