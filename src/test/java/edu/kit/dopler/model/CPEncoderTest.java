package edu.kit.dopler.model;

import com.google.ortools.Loader;
import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.CpSolver;
import com.google.ortools.sat.CpSolverStatus;
import com.google.ortools.sat.IntVar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static edu.kit.dopler.common.DoplerUtils.readDOPLERModelFromFile;
import static edu.kit.dopler.common.SolverUtils.printAllConfigs;
import static org.junit.jupiter.api.Assertions.*;


class CPEncoderTest {

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

    @Test
    void testSpecificModel() {
        Path csvFile = Path.of("src/test/resources/sat_models/greaterThan_test.csv"); //specify model csv here

        System.out.println("Testing: " + csvFile.getFileName().toString());
        Dopler dopler = assertDoesNotThrow(() -> readDOPLERModelFromFile(csvFile), "DOPLER model creation failed!");

        var p = dopler.toCPModel();
        CpModel model = p.a;
        List<IntVar> variables = p.b;

        printAllConfigs(model, variables); //only for debugging reasons

        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);
        assertTrue(status == CpSolverStatus.FEASIBLE || status == CpSolverStatus.OPTIMAL, "Expected SAT for: " + csvFile.getFileName().toString());
    }

    @ParameterizedTest
    @MethodSource("getSATFileNames")
    void testSATModels(Path csvFile) {
        System.out.println("Testing: " + csvFile.getFileName().toString());
        Dopler dopler = assertDoesNotThrow(() -> readDOPLERModelFromFile(csvFile), "DOPLER model creation failed!");

        var p = dopler.toCPModel();
        CpModel model = p.a;
        List<IntVar> variables = p.b;

        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);

        assertTrue(status == CpSolverStatus.FEASIBLE || status == CpSolverStatus.OPTIMAL, "Expected SAT for: " + csvFile.getFileName().toString());
    }

    @ParameterizedTest
    @MethodSource("getUNSATFileNames")
    void testUNSATModels(Path csvFile) {
        System.out.println("Testing: " + csvFile.getFileName().toString());
        Dopler dopler = assertDoesNotThrow(() -> readDOPLERModelFromFile(csvFile), "DOPLER model creation failed!");

        var p = dopler.toCPModel();
        CpModel model = p.a;
        List<IntVar> variables = p.b;

        CpSolver solver = new CpSolver();
        CpSolverStatus status = solver.solve(model);

        assertSame(CpSolverStatus.INFEASIBLE, status, "Expected UNSAT for: " + csvFile.getFileName().toString());
    }

}
