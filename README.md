# SMT based Analysis for Decision Models


## DOPLER META-MODEL

In the following the metamodel of the DOPLER decision model is presented.

#### Validity Condition
Defines the set of allowed values (with respect to the decision type and additional user-defined constraints)
Post condition which has to be fulfilled after a user takes a decision and before assigning a value to the decision variable

#### Visibility Condition
Defines when a decision, becomes relevant and can be answered during product derivation.
If there is a visibility condition associated with a decision, the user has to first take the decisions appearing in the visibility condition
![Dopler Metamodel](/images/DOPLER-METAMODEL.png)



## SMT-LIB Standard
The SMT-LIB standard defines a file format for describing decision problems.
The benefit of a standardized file format is that it is easy to experiment with a range of solvers, and to replace the solver used in case better solvers are
developed.

## SMT Encoding
Therefore, we developed an SMT encoding for the DOPLER Model mentioned before and embedded it to the code.
So in the DOPLER class there exist a methode toSMTStream, which put the whole decision model into a smt encoded stream.
For simplicity, we only explain the encoding in the following with a DOPLER model containing two decisions, but it can be expanded to many more.


### Constants 

```
# Constants for Decision 0
(declare-const DECISION_0_TAKEN_POST bool)
(declare-const DECISION_0_DECISION_0_Salami_PRE bool)
(declare-const DECISION_0_DECISION_0_Salami_POST bool)
(declare-const DECISION_0_DECISION_0_Mozzarella_PRE bool)
(declare-const DECISION_0_DECISION_0_Mozzarella_POST bool)
(declare-const DECISION_0_DECISION_1_PRE double)
(declare-const DECISION_0_DECISION_1_POST double)

# Constants for Decision 1
(declare-const DECISION_1_TAKEN_POST bool)
(declare-const DECISION_1_DECISION_0_Salami_PRE bool)
(declare-const DECISION_1_DECISION_0_Salami_POST bool)
(declare-const DECISION_1_DECISION_0_Mozzarella_PRE bool)
(declare-const DECISION_1_DECISION_0_Mozzarella_POST bool)
(declare-const DECISION_1_DECISION_1_PRE double)
(declare-const DECISION_1_DECISION_1_POST double)

# EndConstants
(declare-const END_DECISION_0_Salami bool)
(declare-const END_DECISION_0_Mozzarella bool)
(declare-const END_DECISION_1 double)
```


### Decisions

```
# enum, bool decisions
(assert 
    (ite (visibilitycondition)  //if
         rules                  //if-part
         mapPretoPostConst      //else
    )
)    


# double, string decisions
(assert 
    (ite (visibilitycondition)  //if
         (ite (validityconditions)     //if-part
                rules                   //if-if-part
                mapPretoPostConst       //if-else-part
         )
         mapPretoPostConst      //else
    )
) 
```

### Rules
```
 (ite (expression) actions mapPretoPostConst)
```


### Actions
```
# Allows -> only for ENUM Decision
    // should not change anything in the SMT stream
    // solver already checks the whole range of the value
    
# Dissallows -> only for ENUM Decision
    (distinct DECISION_0_DECISION_0_DISALLOWEDVALUE_POST false) 
    
# ENFORCE    
    bool, String, double
    (= DECISION_1_DECISION_1_POST enforcedValue)
    
    enum
    (= DECISION_1_DECISION_1_ENFORCEDVALUE_POST true)

```


### Expressions

```
# AND
(and leftExpression rightExpression)

# Xor
(xor leftExpression rightExpression)

# or
(or leftExpression rightExpression)

# GreatherThan
(> leftExpression rightExpression)

# LessThan
(< leftExpression rightExpression)

# NOT
(not expression)

# EQUALS
(= leftExpression rightExpression)

# IsTAKEN
(= DECISION_0_TAKEN_POST true)

# DecisionVisibility
?????

```

