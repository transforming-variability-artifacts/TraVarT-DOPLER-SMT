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

    public void testDoplerModelEShop() throws Exception {

        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());
        BooleanDecision decision1 = new BooleanDecision("Do you want to create an Onlineshop?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);


        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("DebitCard"));
            add(new EnumerationLiteral("CreditCard"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("Which payment methods should be supported??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,2);
        dopler.addDecision(decision2);

        BooleanDecision decision3 = new BooleanDecision("Should a search function be suppoted?","",new BooleanLiteralExpression(true), new HashSet<>());
        IExpression expressionDecision3 = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(false));

        Enumeration enumerationDecision6 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Orders"));
            add(new EnumerationLiteral("Security"));
            add(new EnumerationLiteral("Payments"));
            add(new EnumerationLiteral("Wishlist"));
        }});





        BooleanDecision decision4 = new BooleanDecision("Split products into categories?","",new BooleanLiteralExpression(true), new HashSet<>());


        BooleanDecision decision5 = new BooleanDecision("Should products be sortable?","",new BooleanLiteralExpression(true), new HashSet<>());

        dopler.addDecision(decision4);
        dopler.addDecision(decision5);

        EnumerationDecision decision6 = new EnumerationDecision("Which user management enhancements should be supported?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision6,1,4);
        dopler.addDecision(decision6);

        Rule rule1Decision3 = new Rule(expressionDecision3,new HashSet<>(){{
            add(new EnumEnforce(decision5, BooleanValue.getTrue()));
        }});

        IExpression expression2Decision3 = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(true));

        Rule rule2Decision3 = new Rule(expression2Decision3,new HashSet<>(){{
            add(new EnumEnforce(decision6, new StringValue("Security")));
        }});
        decision3.addRule(rule1Decision3);
        decision3.addRule(rule2Decision3);
        dopler.addDecision(decision3);

        Rule rule1Decision5 = new Rule(
                new Equals(new DecisionValueCallExpression(decision5),new BooleanLiteralExpression(false)),
                new HashSet<>(){{
                    add(new BooleanEnforce(decision3, BooleanValue.getTrue()));
                }});

        decision5.addRule(rule1Decision5);

        decision6.addRule(
                new Rule(
                        new NOT(new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Security"))),
                        new HashSet<>(){{
                            add(new Allows(decision6, new StringValue("Payments")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Security")),
                        new HashSet<>(){{
                            add(new DisAllows(decision6, new StringValue("Payments")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new NOT(new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Payments"))),
                        new HashSet<>(){{
                            add(new Allows(decision6, new StringValue("Security")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new Equals(new DecisionValueCallExpression(decision6),new StringLiteralExpression("Payments")),
                        new HashSet<>(){{
                            add(new DisAllows(decision6, new StringValue("Security")));
                        }}
                )
        );




        dopler.toSMTStream().build().forEach(System.out::println);
        assertTrue(checkSat(dopler));

    }

}
