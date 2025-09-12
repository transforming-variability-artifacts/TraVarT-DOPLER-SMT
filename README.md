# SMT based Analysis for Decision Models

## DOPLER Decision Parser
The DOPLER parser is ANTLR-based with separate lexer and parser grammars and processes an input file (JSON or CSV) in two consecutive listener passes — first to create the Decision objects, second to parse and attach expressions (constraints / visibility conditions) to those previously created decisions. 

This two-pass / multi-listening design is necessary because the input must not enforce a fixed order of decisions and expressions: only after all decisions exist can references like getValue(X) or isTaken(Y) be reliably resolved.

### Setup
Reads the input from the file and creates the corresponding lexer, tokens and parser.
```
		String fileName = "dm_dopler.json";
		CharStream input = CharStreams.fromFileName(fileName);
		DoplerLexer lexer = new DoplerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DoplerParser parser = new DoplerParser(tokens);
```
### Create Parse Tree
Creates the corresponding parse tree of the earlier input, by calling the first parser rule
```
        ParseTree tree = parser.document(); 
        ParseTreeWalker walker = new ParseTreeWalker();
```

### Two-Pass Walk
Performs two consecutive listener walks: the first constructs all decisions, and the second parses expressions and attaches them to their corresponding decisions.
```
		DoplerDecisionCreator decisionCreator = new DoplerDecisionCreator(fileName);
		walker.walk(decisionCreator, tree);
		DoplerExpressionParser expressionParser = new DoplerExpressionParser(decisionCreator.getDopler());
		walker.walk(expressionParser, tree);
```

### Extract Dopler Model
In the last step we extract the resulting DOPLER model from the expressionParser
```
		Dopler dopler = expressionParser.getDopler();
```

### Write Dopler Model
A DoplerModelWriter was implemented to write the model back in either a json or csv file.
```
		DoplerModelWriter dmw = new DoplerModelWriter();
		dmw.writeCSV(dopler, Paths.get("output_dm_dopler.csv"));
		dmw.writeJson(dopler, Paths.get("output_dm_dopler.json"));
```

## DOPLER META-MODEL

In the following the metamodel of the DOPLER decision model is presented.

#### Validity Condition
Defines the set of allowed values (with respect to the decision type and additional user-defined constraints)
Post condition which has to be fulfilled after a user takes a decision and before assigning a value to the decision variable

#### Visibility Condition
Defines when a decision, becomes relevant and can be answered during product derivation.
If there is a visibility condition associated with a decision, the user has to first take the decisions appearing in the visibility condition
![Dopler Metamodel](/images/dOPLER.svg)



## SMT-LIB Standard
The SMT-LIB standard defines a file format for describing decision problems.
The benefit of a standardized file format is that it is easy to experiment with a range of solvers, and to replace the solver used in case better solvers are
developed.

## SMT Encoding
Therefore, we developed an SMT encoding for the DOPLER Model mentioned before and embedded it to the code.
So in the DOPLER class there exist a methode toSMTStream, which put the whole decision model into a smt encoded stream.
For simplicity, we only explain the encoding in the following with a DOPLER model containing two decisions, but it can be expanded to many more.


The basic idea for the encoding with constant mapping comes from the [master thesis](https://epub.jku.at/obvulihs/content/pageview/9482354)  by Florian Alexander Piminger



For the SMT Solver to check possible configuration several constants for every decision are needed.
Especially enum decision need one constant for every enum value the enumeration can have.
This is because the cardinality needs to be checked for the enumeration decision, because the dopler model allows the enumeration decision to have more then one value based on the given min and max cardinality.

Also there have to be all constants for every decision, because every constant can only be assigned once.
The constants are mapped then between the assert of the decision seen late in the ReadMe.
### Constants 

```
# Constants for Decision 0
(declare-const DECISION_0_TAKEN_POST bool)
(declare-const DECISION_0_DECISION_0_Salami_PRE bool)
(declare-const DECISION_0_DECISION_0_Salami_POST bool)
(declare-const DECISION_0_DECISION_0_Mozzarella_PRE bool)
(declare-const DECISION_0_DECISION_0_Mozzarella_POST bool)
(declare-const DECISION_0_DECISION_1_PRE Real)
(declare-const DECISION_0_DECISION_1_POST Real)

# Constants for Decision 1
(declare-const DECISION_1_TAKEN_POST bool)
(declare-const DECISION_1_DECISION_0_Salami_PRE bool)
(declare-const DECISION_1_DECISION_0_Salami_POST bool)
(declare-const DECISION_1_DECISION_0_Mozzarella_PRE bool)
(declare-const DECISION_1_DECISION_0_Mozzarella_POST bool)
(declare-const DECISION_1_DECISION_1_PRE Real)
(declare-const DECISION_1_DECISION_1_POST Real)

# EndConstants
(declare-const END_DECISION_0_Salami bool)
(declare-const END_DECISION_0_Mozzarella bool)
(declare-const END_DECISION_1 Real)
```



For the DOPLER model every decision gets asserted and between the asserts of the decisions there are asserts to map the post constants from the decision to the pre constants of the next decision.
The encoding of the decisions and the mappings get explained in the following.
### DOPLER

```

(assert Decision0)
(assert (Mapping between Decision0 and Decision1))
(assert Decision1)
(assert (Mapping between Decision1 and EndConstants))

```


### Decisions


#### Basic ENUM and Bool Decisions
```
 (assert 
    (ite 
        (visibilitycondition)  //if
        (and setTaken(true) rules)                  //if-part
        (and                //else-part
            setTaken(false)
            setDefaultValue                   
            mapPretoPostConst       
        )
    )
 ) 
```
#### ENUM and Bool Decisions, if VisibilityCondition is LiteralExpression
```
# if LiteralExpression is True

    (assert  (and setTaken(true) rules))
 
# if LiteralExpression is False

    (assert 
       (and                
            setTaken(false)
            setDefaultValue                   
            mapPretoPostConst       
        )
    )

```
#### Basic String and Double Decisions

```
(assert 
    (ite (visibilitycondition)  //if
         (ite (validityconditions)     //if-part
                (and setTaken(true) rules)              //if-if-part
                (and                //if-else-part
                    setTaken(false)
                    setDefaultValue                   
                    mapPretoPostConst       
                )      
         )
        (and                //else-part
            setTaken(false)
            setDefaultValue                   
            mapPretoPostConst       
        )  
    )
) 
```
#### String and Double Decisions, if VisibilityCondition is LiteralExpression

```
# if LiteralExpression is True
    (assert           
         (ite 
            (validityconditions)    // condition
            (and setTaken(true) rules)            //if part
            (and                //else-part
                setTaken(false)
                setDefaultValue                   
                mapPretoPostConst       
            )
         )                   
    )  

# if LiteralExpression is False
    (assert
        (and                
                setTaken(false)
                setDefaultValue                   
                mapPretoPostConst       
        )
    )
```

#### String and Double Decisions, if ValidityExpression is LiteralExpression
```
# if LiteralExpression is True
(assert 
    (ite (visibilitycondition)  //if
        (and setTaken(true) rules)            //if part
        (and                //else-part
            setTaken(false)
            setDefaultValue                   
            mapPretoPostConst       
        )
    )
) 

# if LiteralExpression is False

(assert 
    (and                
            setTaken(false)
            setDefaultValue                   
            mapPretoPostConst       
    )
) 
```


### Mapping between Decisions
```
(and
    (= DECISION_0_DECISION_0_Salami_POST DECISION_1_DECISION_0_Salami_PRE)
    (= DECISION_0_DECISION_1_POST DECISION_1_DECISION_1_PRE  )
)
```

### Mapping PRE to POST CONST
```
(and
    (= DECISION_0_DECISION_0_Salami_PRE DECISION_0_DECISION_0_Salami_POST )
    (= DECISION_0_DECISION_1_PRE DECISION_0_DECISION_1_POST )
)
```

### setTaken(Decision_i, true/false)
```
(= DECISION_i_TAKEN true/false)
```


### setDefaultValue
```
```

### Cardinality Constraints
```
(assert
    (ite
        (= DECISION_i_TAKEN true)
        (and
            (>=
                (+ (ite Enumerationliteral_i_j 1 0) · · · (ite Enumerationliteral_i_J 1 0))
            n)
            (<=
                (+ (ite Enumerationliteral_i_j 1 0) · · · (ite Enumerationliteral_i_J 1 0))
            m)
        )
        (= true true)
    )
)
```

### Rules
```
 (ite (expression) actions mapPretoPostConst)
```


### Actions


#### Allows -> only for ENUM Decision
```
should not change anything in the SMT stream
solver already checks the whole range of the value
```
#### Dissallows -> only for ENUM Decision
```    
    (distinct DECISION_0_DECISION_0_DISALLOWEDVALUE_POST true) 
```

#### ENFORCE for Boolean, String, Double Decisions
```
    (= DECISION_1_DECISION_1_POST enforcedValue)
```

### ENFORCE for Enum Decision 
```
    (= DECISION_1_DECISION_1_ENFORCEDVALUE_POST true)
```


### Expressions

#### AND

```
(and leftExpression rightExpression)
```


#### XOR

```
(xor leftExpression rightExpression)
```


#### OR
```
(or leftExpression rightExpression)
```

#### GreatherThan
```
(> leftExpression rightExpression)
```
#### LessThan

```
(< leftExpression rightExpression)
```


#### NOT
```
(not expression)
```

#### EQUALS
```
(= leftExpression rightExpression)
```

#### IsTAKEN

```
(= DECISION_0_TAKEN_POST true)
```
#### DecisionVisibility
```
decisionVisibility.ToSMTSTREAM()
```
#### DecisionVisibility if its only a LiteralExpression
```
# IF LiteralExpression TRUE
(=  true true)

# IF LiteralExpression False
(= true false)
```