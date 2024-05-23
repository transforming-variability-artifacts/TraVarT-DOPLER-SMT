package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ValidityConditionException;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThrows;

public class NumberDecisionTest extends TestCase {

    private NumberDecision numberDecision;


    public void setUp() throws Exception {
        super.setUp();

        Expression expression = new BooleanLiteralExpression(true);
        numberDecision = new NumberDecision("0","test","test",expression,false, new HashSet<>(),new HashSet<>());
    }


    public void testStandardValue(){
        assertSame("-1.0",numberDecision.getStandardValue().getValue().toString());
    }

    public void testSetValueWhichDontFullFillsValidityCondition(){
        DoubleLiteralExpression doubleLiteralExpression = new DoubleLiteralExpression(2.0);
        DecisionValueCallExpression decisionValueCallExpression = new DecisionValueCallExpression(numberDecision);
        GreatherThan greatherThan = new GreatherThan(decisionValueCallExpression,doubleLiteralExpression);
        Set<IExpression> expressions = new HashSet<>();
        expressions.add(greatherThan);
        numberDecision.setValidityConditions(expressions);
        assertThrows(ValidityConditionException.class,() -> numberDecision.setValue(new DoubleValue(1.0)));
    }



}