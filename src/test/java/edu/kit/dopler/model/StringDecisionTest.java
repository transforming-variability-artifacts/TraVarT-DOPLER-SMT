package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ValidityConditionException;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThrows;

public class StringDecisionTest extends TestCase {

    private StringDecision stringDecision;

    public void setUp() throws Exception {
        super.setUp();

        Expression expression = new BooleanLiteralExpression(true);
        stringDecision = new StringDecision("test","test",expression,false, new HashSet<>(),new HashSet<>());
    }


    public void testSetValueWhichDontFullFillsValidityCondition(){
        StringLiteralExpression stringLiteralExpression = new StringLiteralExpression("test");
        DecisionValueCallExpression decisionValueCallExpression = new DecisionValueCallExpression(stringDecision);
        Equals equals = new Equals(decisionValueCallExpression,stringLiteralExpression);
        Set<IExpression> expressions = new HashSet<>();
        expressions.add(equals);
        stringDecision.setValidityConditions(expressions);
        assertThrows(ValidityConditionException.class,() -> stringDecision.setValue(new StringValue("test2")));
        assertEquals(new StringValue("null").getValue(), stringDecision.getValue().getValue());
        assertFalse(stringDecision.isTaken());
    }

    public void testSetValueWhichFullFillsValidityCondition() throws ValidityConditionException {
        StringLiteralExpression stringLiteralExpression = new StringLiteralExpression("test");
        DecisionValueCallExpression decisionValueCallExpression = new DecisionValueCallExpression(stringDecision);
        Equals equals = new Equals(decisionValueCallExpression,stringLiteralExpression);
        Set<IExpression> expressions = new HashSet<>();
        expressions.add(equals);
        stringDecision.setValidityConditions(expressions);
        IValue<String> stringIValue = new StringValue("test");
        stringDecision.setValue(stringIValue);
        assertEquals(stringIValue.getValue(),stringDecision.getValue().getValue());
        assertTrue(stringDecision.isTaken());
    }

    public void testStandardValue(){
        assertEquals("null",stringDecision.getStandardValue());
    }




}