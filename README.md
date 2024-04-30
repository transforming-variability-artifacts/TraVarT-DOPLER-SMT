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

