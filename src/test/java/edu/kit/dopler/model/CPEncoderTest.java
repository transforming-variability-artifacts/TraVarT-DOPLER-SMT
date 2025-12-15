package edu.kit.dopler.model;

import com.google.ortools.Loader;
import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.CpSolver;
import com.google.ortools.sat.CpSolverStatus;
import com.google.ortools.sat.IntVar;
import edu.kit.dopler.io.antlr.DoplerDecisionCreator;
import edu.kit.dopler.io.antlr.DoplerExpressionParser;
import edu.kit.dopler.io.antlr.resources.DoplerLexer;
import edu.kit.dopler.io.antlr.resources.DoplerParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class CPEncoderTest {

    @BeforeAll
    public static void beforeClass() throws Exception {
        Loader.loadNativeLibraries();
    }

    static Stream<Path> getSATFileNames() throws IOException {
        Path dir = Paths.get("src/test/resources/sat_models");
        try (Stream<Path> files = Files.list(dir)) {
            return files.filter(Files::isRegularFile).map(Path::toAbsolutePath).toList().stream();
        }
    }

    static Stream<Path> getUNSATFileNames() throws IOException {
        Path dir = Paths.get("src/test/resources/unsat_models");
        try (Stream<Path> files = Files.list(dir)) {
            return files.filter(Files::isRegularFile).map(Path::toAbsolutePath).toList().stream();
        }
    }

    @ParameterizedTest
    @MethodSource("getSATFileNames")
    void testSATModels(Path csvFile) {
        Dopler dopler = assertDoesNotThrow(() -> loadDoplerFromCsv(csvFile), "DOPLER model creation failed!");

        var p = dopler.toCPModel();
        CpModel model = p.a;
        ArrayList<IntVar> variables = p.b;

        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);

        assertTrue(status == CpSolverStatus.FEASIBLE || status == CpSolverStatus.OPTIMAL, "Expected SAT for: " + csvFile.getFileName().toString());
    }

    @ParameterizedTest
    @MethodSource("getUNSATFileNames")
    void testUNSATModels(Path csvFile) {
        Dopler dopler = assertDoesNotThrow(() -> loadDoplerFromCsv(csvFile), "DOPLER model creation failed!");

        var p = dopler.toCPModel();
        CpModel model = p.a;
        ArrayList<IntVar> variables = p.b;

        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);

        assertSame(CpSolverStatus.INFEASIBLE, status, "Expected UNSAT for: " + csvFile.getFileName().toString());
    }

    private Dopler loadDoplerFromCsv(Path csvPath) throws IOException {
        CharStream input = CharStreams.fromFileName(csvPath.toString());
        DoplerLexer lexer = new DoplerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DoplerParser parser = new DoplerParser(tokens);
        ParseTree tree = parser.document();
        ParseTreeWalker walker = new ParseTreeWalker();
        DoplerDecisionCreator decisionCreator = new DoplerDecisionCreator(csvPath.toString());
        walker.walk(decisionCreator, tree);
        DoplerExpressionParser expressionParser = new DoplerExpressionParser(decisionCreator.getDopler());
        walker.walk(expressionParser, tree);
        return expressionParser.getDopler();
    }

}
