# CP Encoding Design Decisions

## Google OR-Tools (CP-SAT-Solver)
The CP encoding uses the [Google OR-Tools CP-SAT solver](https://developers.google.com/optimization/cp/cp_solver). 
This library provides a powerful constraint programming solver that can handle boolean, integer, and linear constraints.

## CP Encoding
The CP encoding is implemented in the `Dopler` class via the `toCPModel` method. 
It returns a `CpEncodingResult` which contains the constraints programming (CP) model and the mapping of decisions to their corresponding CP variables.
This enables users to display satisfiable configurations later on.
The encoding is described in detail below.

TODO: Explain why string and java decisions are left out! 

### Decision Variables
For every decision in the DOPLER model, one or more CP variables are created:
- **Boolean Decisions**: A single `BoolVar`.
- **Enumeration Decisions**: Multiple `BoolVar(s)`, one for each literal in the enumeration.
- **Number Decisions**: An `IntVar`.

Additionally, for each decision, a `BoolVar` named `Decision_<ID>_isTaken` is created to track whether the decision is taken in a current configuration.

### Constraints
After the decision variables are created, different constraints are added to the model.
First, the constraints representing the rules of the decision are added, and then constraints for potential standard values are added.
These constraints are described in detail below.

#### Rules
A decision rule consists of a condition expression and associated actions.
If the condition holds and the decision is taken, those actions are executed.
The CP literal `conditionLiteral` encodes this logic:
> $conditionLiteral \iff (isTaken \land ruleCondition)$

The following describes how the actions are encoded in the CP model.

##### BooleanEnforce
To enforce a boolean decision, we add the following constraint:
> $conditionLiteral \implies (booleanDecision = value)$

We use this implication to ensure that the action is executed if the `conditionLiteral` holds.
If the `conditionLiteral` does not hold, we do not care whether the action is executed.
The Java code to achieve this is as follows:
```
 model.addEquality(booleanDecision, value).onlyEnforceIf(conditionLiteral);
```

##### EnumEnforce
To enforce an enumeration decision, we proceed the same way as we do for boolean decisions.
We only first need to choose the correct CP variable for the given enumeration literal.

##### NumberEnforce
To enforce a number decision, we again proceed the same way as we do for boolean decisions.

##### DisAllows
The disallows action is only relevant for enumeration decisions.
To ensure that a given enumeration literal is not chosen, we perform an enumEnforce where the value we enforce is the false literal.

##### Allows
The allows action is only relevant for enumeration decisions.
To ensure that a given enumeration literal can be chosen, we have to do nothing since the CP solver already checks the whole range of possible values for each variable.


#### Standard Values
For every decision that is not taken, we add a constraint that enforces the standard value.

<!-- TODO etwas ausführlicher hier + validity conditions: cardinality and range erklären-->


### Expression Literals
For every DOPLER expression, there is a `toCPLiteral` method that returns a corresponding CP literal.
This literal can then be used in constraints (see [above](#constraints)).
The following describes how each expression is represented as a CP literal.

#### NOT
The CP solver natively supports negations.
> $\lnot expression$

Java code to achieve this:
```
expression.not();
```

#### IsTAKEN
For the isTaken expression, we use the `Decision_<ID>_isTaken` variable indroduced above.
> $Decision\textunderscore\<ID\>\textunderscore isTaken$

<!-- TODO hier evtl auch java code + ggf dann auch die 3 maps die ich nutze erklären -->

#### Binary Expressions
All binary expressions follow the general form: `leftExpression <operation> rightExpression`.

To represent such a binary expression, a special `BoolVar` (called `equivalentLiteral`) is created.
The following describes how this `equivalentLiteral` is made to represent different binary expressions.
The formulas may seem confusing or unnecessarily complex at first.
However, this is because the CP solver only allows a limited set of internal operators. Therefore, complex logic, such as equivalences, must be encoded via these formulas.

##### AND
<!-- TODO vllt kann man den redundanten text kürzen... -->

For this operation, we want to ensure that the following holds: $equivalentLiteral \iff (leftExpression \land rightExpression)$.

To achieve this, we add constraints representing the bidirectional implications ' $\implies$ ' and ' $\impliedby$ ' to the CP model:

> ' $\implies$ ' : $(\lnot equivalentLiteral \lor leftExpression) \land (\lnot equivalentLiteral \lor rightLiteral)$
>
> ' $\impliedby$ ' : $\lnot leftExpression \lor \lnot rightExpression \lor equivalentLiteral$

Java code to achieve this:
```
BoolVar equivalentLiteral = model.newBoolVar("equivalentLiteral");

//ensure that: equivalentLiteral <=> (leftLiteral and rightLiteral)
// "=>" as CNF
model.addBoolOr(new Literal[]{equivalentLiteral.not(), leftLiteral});
model.addBoolOr(new Literal[]{equivalentLiteral.not(), rightLiteral});

// "<=" as CNF
model.addBoolOr(new Literal[]{leftLiteral.not(), rightLiteral.not(), equivalentLiteral});
```

##### OR
For this operation, we want to ensure that the following holds: $equivalentLiteral \iff (leftExpression \lor rightExpression)$.

To achieve this, we add constraints representing the bidirectional implications ' $\implies$ ' and ' $\impliedby$ ' to the CP model:

> ' $\implies$ ' : $\lnot equivalentLiteral \lor leftExpression \lor rightExpression$
>
> ' $\impliedby$ ' : $(\lnot leftExpression \lor equivalentLiteral) \land (\lnot rightExpression \lor equivalentLiteral)$

Java code to achieve this:
```
BoolVar equivalentLiteral = model.newBoolVar("equivalentLiteral");

//ensure that: equivalentLiteral <=> (leftLiteral or rightLiteral)
// "=>" as CNF
model.addBoolOr(new Literal[]{equivalentLiteral.not(), leftLiteral, rightLiteral});

// "<=" as CNF
model.addBoolOr(new Literal[]{leftLiteral.not(), equivalentLiteral});
model.addBoolOr(new Literal[]{rightLiteral.not(), equivalentLiteral});
```

##### XOR
For this operation, we want to ensure that the following holds: $equivalentLiteral \iff (leftExpression \oplus rightExpression)$.

To achieve this, we add constraints representing the bidirectional implications ' $\implies$ ' and ' $\impliedby$ ' to the CP model:

> ' $\implies$ ' : $(\lnot equivalentLiteral \lor  leftExpression \lor rightExpression) \land (\lnot equivalentLiteral \lor \lnot leftExpression \lor \lnot rightExpression)$
>
> ' $\impliedby$ ' : $(equivalentLiteral \lor  leftExpression \lor \lnot rightExpression) \land (equivalentLiteral \lor  \lnot leftExpression \lor rightExpression)$

Java code to achieve this:
```
BoolVar equivalentLiteral = model.newBoolVar("equivalentLiteral");

//ensure that: equivalentLiteral <=> (leftLiteral xor rightLiteral)
// "=>" as CNF
model.addBoolOr(new Literal[]{equivalentLiteral.not(), leftLiteral, rightLiteral});
model.addBoolOr(new Literal[]{equivalentLiteral.not(), leftLiteral.not(), rightLiteral.not()});

// "<=" as CNF
model.addBoolOr(new Literal[]{equivalentLiteral, leftLiteral, rightLiteral.not()});
model.addBoolOr(new Literal[]{equivalentLiteral, leftLiteral.not(), rightLiteral});
```

##### GreaterThan
For this operation, we want to ensure that the following holds: $equivalentLiteral \iff (leftExpression \gt rightExpression)$.

To achieve this, we add constraints representing the bidirectional implications ' $\implies$ ' and ' $\impliedby$ ' to the CP model:

> ' $\implies$ ' : $equivalentLiteral \implies (leftExpression \gt rightExpression)$
>
> ' $\impliedby$ ' : $\lnot equivalentLiteral \implies (leftExpression \leq rightExpression)$

Java code to achieve this:
```
BoolVar equivalentLiteral = model.newBoolVar("equivalentLiteral");

//ensure that: equivalentLiteral <=> (left > right)
// "=>": equivalentLiteral => (left > right)
model.addGreaterThan(left, right).onlyEnforceIf(equivalentLiteral);

// "<=": !equivalentLiteral => (left <= right)
model.addLessOrEqual(left, right).onlyEnforceIf(equivalentLiteral.not());
```

##### LessThan
For this operation, we want to ensure that the following holds: $equivalentLiteral \iff (leftExpression \lt rightExpression)$.

To achieve this, we add constraints representing the bidirectional implications ' $\implies$ ' and ' $\impliedby$ ' to the CP model:

> ' $\implies$ ' : $equivalentLiteral \implies (leftExpression \lt rightExpression)$
>
> ' $\impliedby$ ' : $\lnot equivalentLiteral \implies (leftExpression \geq rightExpression)$

Java code to achieve this:
```
BoolVar equivalentLiteral = model.newBoolVar("equivalentLiteral");

//ensure that: equivalentLiteral <=> (left < right)
// "=>": equivalentLiteral => (left < right)
model.addLessThan(left, right).onlyEnforceIf(equivalentLiteral);

// "<=": !equivalentLiteral => (left >= right)
model.addGreaterOrEqual(left, right).onlyEnforceIf(equivalentLiteral.not());
```

##### EQUALS
For this operation, we want to ensure that the following holds: $equivalentLiteral \iff (leftExpression = rightExpression)$.

To achieve this, we add constraints representing the bidirectional implications ' $\implies$ ' and ' $\impliedby$ ' to the CP model:

> ' $\implies$ ' : $equivalentLiteral \implies (leftExpression = rightExpression)$
>
> ' $\impliedby$ ' : $\lnot equivalentLiteral \implies (leftExpression \neq rightExpression)$

Java code to achieve this:
```
BoolVar equivalentLiteral = model.newBoolVar("equivalentLiteral");

//ensure that: equivalentLiteral <=> (left == right)
// "=>": equivalentLiteral => (left == right)
model.addEquality(left, right).onlyEnforceIf(equivalentLiteral);

// "<=": !equivalentLiteral => (left != right)
model.addDifferent(left, right).onlyEnforceIf(equivalentLiteral.not());
```
