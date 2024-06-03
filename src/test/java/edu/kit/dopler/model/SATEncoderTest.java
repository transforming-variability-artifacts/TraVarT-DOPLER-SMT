package edu.kit.dopler.model;

import junit.framework.TestCase;

import java.util.HashSet;

import static edu.kit.dopler.model.Main.checkSat;

public class SATEncoderTest extends TestCase {




    public void testDoplerModelVaMoS() throws Exception {

        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());
        BooleanDecision decision1 = new BooleanDecision("Support GSM 1900 protocol?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);


        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("WAV"));
            add(new EnumerationLiteral("MP3"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("Which audio formats shall be supported?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,2);
        dopler.addDecision(decision2);

        BooleanDecision decision3 = new BooleanDecision("Support for taking photos?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision3);


        Enumeration enumerationDecision4 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("2.1MP"));
            add(new EnumerationLiteral("5MP"));
            add(new EnumerationLiteral("3.1MP"));
        }});

        IExpression expression = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(true));
        EnumerationDecision decision4 = new EnumerationDecision("Required camera resolution?","", expression, new HashSet<>(),enumerationDecision4,1,3);
        dopler.addDecision(decision4);





        BooleanDecision decision5 = new BooleanDecision("Support for recording MP3 audio?","",new BooleanLiteralExpression(true), new HashSet<>());
        IExpression expression2 = new Equals(new DecisionValueCallExpression(decision5),new BooleanLiteralExpression(true));

        Rule rule = new Rule(expression2,new HashSet<>(){{
            add(new EnumEnforce(decision2, new StringValue("MP3")));
        }});
        decision5.addRule(rule);
        dopler.addDecision(decision5);

        dopler.toSMTStream().build().forEach(System.out::println);
        assertTrue(checkSat(dopler));

    }



}
