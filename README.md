# SMT based Analysis for Decision Models

## Run
This tool invokes the Z3 SMT solver. You can now pass the path to your Z3 binary when starting the program:

- As first argument: `java -jar smt_dopler-2.0.0.jar /full/path/to/z3`
- Or with flags: `java -jar smt_dopler-2.0.0.jar --z3=/full/path/to/z3` or `-z /full/path/to/z3`
- Or via environment variable: `Z3_PATH=/full/path/to/z3 java -jar smt_dopler-2.0.0.jar`

Help:

- `java -jar smt_dopler-2.0.0.jar --help`

If no path is provided, the program will try to execute `z3` from your PATH.

## Parser

Information about the parser see [here](Parser.md)

## DOPLER META-MODEL

In the following the metamodel of the DOPLER decision model is presented.

#### Validity Condition
Defines the set of allowed values (with respect to the decision type and additional user-defined constraints)
Post condition which has to be fulfilled after a user takes a decision and before assigning a value to the decision variable

#### Visibility Condition
Defines when a decision, becomes relevant and can be answered during product derivation.
If there is a visibility condition associated with a decision, the user has to first take the decisions appearing in the visibility condition
![Dopler Metamodel](/images/dOPLER.svg)


## SMT Encoding

Detailed Explanation of the Encoding you can find [here](SMTEncoding.md)

## CI Pipeline

This project uses a GitHub Actions CI pipeline to automatically build the project and run all tests. The pipeline does this by:

- Downloading the required CSV test data from an external repository.
- Building the project and running unit tests using the **Maven Wrapper**.
- Publishing test reports as GitHub checks in pull requests.

The **Maven Wrapper** is used to ensure a consistent Maven version across all environments, making builds reproducible and setup easier.

