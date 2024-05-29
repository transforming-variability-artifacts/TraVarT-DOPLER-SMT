package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ValidityConditionException;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThrows;

public class EnumerationDecisionTest extends TestCase {

    private EnumerationDecision enumerationDecision;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Set<EnumerationLiteral>  enumerationLiterals = new HashSet<>();
        enumerationLiterals.add(new EnumerationLiteral("test1"));
        enumerationLiterals.add((new EnumerationLiteral("test2")));
        Enumeration enumeration = new edu.kit.dopler.model.Enumeration(enumerationLiterals);
        Expression expression = new BooleanLiteralExpression(true);
        enumerationDecision = new EnumerationDecision("test","test",expression,false,new HashSet<>(),enumeration,0,2);
    }

    public void testSetValueWithOutOfRangeValue(){
        assertThrows(ValidityConditionException.class,() -> enumerationDecision.setValue(new StringValue("test3")));
    }

    public void testSetValueWithDisallowedValue(){
        enumerationDecision.addDissallowed(new EnumerationLiteral("test2"));
        assertThrows(ValidityConditionException.class,() -> enumerationDecision.setValue(new StringValue("test2")));

    }

    public void testSetValueCorrect() throws ValidityConditionException {
        assertFalse(enumerationDecision.isTaken());
        assertSame(enumerationDecision.getValue().getValue(),enumerationDecision.getStandardValue());
        IValue<String> testLiteral = new StringValue("test1");
        enumerationDecision.setValue(testLiteral);
        assertSame(enumerationDecision.getValue().getValue(),testLiteral.getValue());
        assertTrue(enumerationDecision.isTaken());
    }

    public void testStandardValue(){
        assertSame(enumerationDecision.getStandardValue(),"null");
    }

}