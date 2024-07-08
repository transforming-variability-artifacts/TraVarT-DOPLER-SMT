package edu.kit.dopler.model;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.stream.Stream;

import static edu.kit.dopler.model.Main.checkSat;

public class SATEncoderTest extends TestCase {




    public void testDoplerModelVaMoS() throws Exception {

        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());
        BooleanDecision decision1 = new BooleanDecision("test", "Support GSM 1900 protocol?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);


        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("WAV"));
            add(new EnumerationLiteral("MP3"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("test", "Which audio formats shall be supported?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,2);
        dopler.addDecision(decision2);

        BooleanDecision decision3 = new BooleanDecision("test", "Support for taking photos?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision3);


        Enumeration enumerationDecision4 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("2.1MP"));
            add(new EnumerationLiteral("5MP"));
            add(new EnumerationLiteral("3.1MP"));
        }});

        IExpression expression = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(true));
        EnumerationDecision decision4 = new EnumerationDecision("test", "Required camera resolution?","", expression, new HashSet<>(),enumerationDecision4,1,1);
        dopler.addDecision(decision4);





        BooleanDecision decision5 = new BooleanDecision("test", "Support for recording MP3 audio?","",new BooleanLiteralExpression(true), new HashSet<>());
        IExpression expression2 = new Equals(new DecisionValueCallExpression(decision5),new BooleanLiteralExpression(true));

        Rule rule = new Rule(expression2,new HashSet<>(){{
            add(new EnumEnforce(decision2, new StringValue("MP3")));
        }});
        decision5.addRule(rule);
        dopler.addDecision(decision5);

        dopler.toSMTStream().build().forEach(System.out::println);
        assertTrue(checkSat(dopler.toSMTStream()));

    }

    public void testDoplerModelEShop() throws Exception {

        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());
        BooleanDecision decision1 = new BooleanDecision("test", "Do you want to create an Onlineshop?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);


        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("DebitCard"));
            add(new EnumerationLiteral("CreditCard"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("test", "Which payment methods should be supported??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,1);
        dopler.addDecision(decision2);

        BooleanDecision decision3 = new BooleanDecision("test", "Should a search function be suppoted?","",new BooleanLiteralExpression(true), new HashSet<>());
        IExpression expressionDecision3 = new Equals(new DecisionValueCallExpression(decision3),new BooleanLiteralExpression(false));

        Enumeration enumerationDecision6 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Orders"));
            add(new EnumerationLiteral("Security"));
            add(new EnumerationLiteral("Payments"));
            add(new EnumerationLiteral("Wishlist"));
        }});





        BooleanDecision decision4 = new BooleanDecision("test", "Split products into categories?","",new BooleanLiteralExpression(true), new HashSet<>());


        BooleanDecision decision5 = new BooleanDecision("test", "Should products be sortable?","",new BooleanLiteralExpression(true), new HashSet<>());

        dopler.addDecision(decision4);
        dopler.addDecision(decision5);

        EnumerationDecision decision6 = new EnumerationDecision("test", "Which user management enhancements should be supported?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision6,1,4);
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
                        new NOT(new Equals(new DecisionValueCallExpression(decision6),new EnumeratorLiteralExpression(new EnumerationLiteral("Security")))),
                        new HashSet<>(){{
                            add(new Allows(decision6, new StringValue("Payments")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new Equals(new DecisionValueCallExpression(decision6),new EnumeratorLiteralExpression(new EnumerationLiteral("Security"))),
                        new HashSet<>(){{
                            add(new DisAllows(decision6, new StringValue("Payments")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new NOT(new Equals(new DecisionValueCallExpression(decision6),new EnumeratorLiteralExpression(new EnumerationLiteral("Payments")))),
                        new HashSet<>(){{
                            add(new Allows(decision6, new StringValue("Security")));
                        }}
                )
        );

        decision6.addRule(
                new Rule(
                        new Equals(new DecisionValueCallExpression(decision6),new EnumeratorLiteralExpression(new EnumerationLiteral("Payments"))),
                        new HashSet<>(){{
                            add(new DisAllows(decision6, new StringValue("Security")));
                        }}
                )
        );




        dopler.toSMTStream().build().forEach(System.out::println);
        assertTrue(checkSat(dopler.toSMTStream()));

    }


    public void testDoplerModelPizzas() throws Exception {
        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());



        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Salami"));
            add(new EnumerationLiteral("Ham"));
            add(new EnumerationLiteral("Mozzarella"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("test", "Which Topping do you want on your pizza?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,3);
        dopler.addDecision(decision2);


        Enumeration enumerationDecision3 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Normal"));
            add(new EnumerationLiteral("Big"));
        }});
        EnumerationDecision decision3 = new EnumerationDecision("test", "Which Size should the pizza have?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision3,1,1);
        dopler.addDecision(decision3);


        Enumeration enumerationDecision4 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Neapolitan"));
            add(new EnumerationLiteral("Sicilian"));
        }});
        EnumerationDecision decision4 = new EnumerationDecision("test", "Which Dough do you prefer??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision4,1,1);
        dopler.addDecision(decision4);


        BooleanDecision decision1 = new BooleanDecision("test", "Should the pizza have a cheesy crust?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);

        IExpression expressionDecision1 = new Equals(new DecisionValueCallExpression(decision1),new BooleanLiteralExpression(true));

        Rule ruleDecision1 = new Rule(expressionDecision1,new HashSet<>(){{
            add(new EnumEnforce(decision3, new StringValue("Big")));
        }});
        decision1.addRule(ruleDecision1);

        dopler.toSMTStream().build().forEach(System.out::println);
        assertTrue(checkSat(dopler.toSMTStream()));

    }


    public void testDoplerModelPizzas2() throws Exception {
        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());



        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Salami"));
            add(new EnumerationLiteral("Ham"));
            add(new EnumerationLiteral("Mozzarella"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("test", "Which Topping do you want on your pizza?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,3);
        dopler.addDecision(decision2);


        Enumeration enumerationDecision3 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Normal"));
            add(new EnumerationLiteral("Big"));
        }});
        EnumerationDecision decision3 = new EnumerationDecision("test", "Which Size should the pizza have?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision3,1,1);
        dopler.addDecision(decision3);


        Enumeration enumerationDecision4 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Neapolitan"));
            add(new EnumerationLiteral("Sicilian"));
        }});
        EnumerationDecision decision4 = new EnumerationDecision("test", "Which Dough do you prefer??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision4,1,1);
        dopler.addDecision(decision4);


        BooleanDecision decision1 = new BooleanDecision("test", "Should the pizza have a cheesy crust?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);

        IExpression expressionDecision3 = new Equals(new DecisionValueCallExpression(decision3),new EnumeratorLiteralExpression(new EnumerationLiteral("Big")));

        Rule ruleDecision3 = new Rule(expressionDecision3,new HashSet<>(){{
            add(new EnumEnforce(decision4, new StringValue("Neapolitan")));
        }});
        decision3.addRule(ruleDecision3);

        IExpression expressionDecision4 = new Equals(new DecisionValueCallExpression(decision4),new EnumeratorLiteralExpression(new EnumerationLiteral("Sicilian")));

        Rule ruleDecision4 = new Rule(expressionDecision4,new HashSet<>(){{
            add(new BooleanEnforce(decision1, BooleanValue.getTrue()));
        }});
        decision4.addRule(ruleDecision4);



        IExpression expressionDecision1 = new Equals(new DecisionValueCallExpression(decision1),new BooleanLiteralExpression(true));

        Rule ruleDecision1 = new Rule(expressionDecision1,new HashSet<>(){{
            add(new EnumEnforce(decision3, new StringValue("Big")));
        }});
        decision1.addRule(ruleDecision1);

        dopler.toSMTStream().build().forEach(System.out::println);
        assertTrue(checkSat(dopler.toSMTStream()));

    }

    public void testDoplerModelPizzas2withUnsatAssert() throws Exception {
        Dopler dopler = new Dopler(new HashSet<>(),new HashSet<>(),new HashSet<>());



        Enumeration enumerationDecision2 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Salami"));
            add(new EnumerationLiteral("Ham"));
            add(new EnumerationLiteral("Mozzarella"));
        }});
        EnumerationDecision decision2 = new EnumerationDecision("test", "Which Topping do you want on your pizza?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision2,1,3);
        dopler.addDecision(decision2);


        Enumeration enumerationDecision3 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Normal"));
            add(new EnumerationLiteral("Big"));
        }});
        EnumerationDecision decision3 = new EnumerationDecision("test", "Which Size should the pizza have?","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision3,1,1);
        dopler.addDecision(decision3);


        Enumeration enumerationDecision4 = new Enumeration(new HashSet<>(){{
            add(new EnumerationLiteral("Neapolitan"));
            add(new EnumerationLiteral("Sicilian"));
        }});
        EnumerationDecision decision4 = new EnumerationDecision("test", "Which Dough do you prefer??","", new BooleanLiteralExpression(true), new HashSet<>(),enumerationDecision4,1,1);
        dopler.addDecision(decision4);


        BooleanDecision decision1 = new BooleanDecision("test", "Should the pizza have a cheesy crust?","",new BooleanLiteralExpression(true), new HashSet<>());
        dopler.addDecision(decision1);

        IExpression expressionDecision3 = new Equals(new DecisionValueCallExpression(decision3),new EnumeratorLiteralExpression(new EnumerationLiteral("Big")));

        Rule ruleDecision3 = new Rule(expressionDecision3,new HashSet<>(){{
            add(new EnumEnforce(decision4, new StringValue("Neapolitan")));
        }});
        decision3.addRule(ruleDecision3);

        IExpression expressionDecision4 = new Equals(new DecisionValueCallExpression(decision4),new EnumeratorLiteralExpression(new EnumerationLiteral("Sicilian")));

        Rule ruleDecision4 = new Rule(expressionDecision4,new HashSet<>(){{
            add(new BooleanEnforce(decision1, BooleanValue.getTrue()));
        }});
        decision4.addRule(ruleDecision4);



        IExpression expressionDecision1 = new Equals(new DecisionValueCallExpression(decision1),new BooleanLiteralExpression(true));

        Rule ruleDecision1 = new Rule(expressionDecision1,new HashSet<>(){{
            add(new EnumEnforce(decision3, new StringValue("Big")));
        }});
        decision1.addRule(ruleDecision1);

        dopler.toSMTStream().build().forEach(System.out::println);
        Stream.Builder<String> builder = dopler.toSMTStream();
        builder.add("(assert (= END_DECISION_2_Sicilian true))");
        assertFalse(checkSat(builder));

    }

}
