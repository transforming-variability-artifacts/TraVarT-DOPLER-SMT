package edu.kit.dopler.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.common.SolverUtils;

public class CSVModlesTest {

    @Test
    public void testModelAParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/A.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelAPLParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/APL.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelASEJ1ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/ASEJ1.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        int amountDesicions = doplerModel.getDecisions().size();
        assertEquals(amountDesicions, 3391);

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelASEJ2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/ASEJ2.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelAllTheCombinationsParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/AllTheCombinations.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelAlwaysTrueParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/AlwaysTrue.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelArtefactsAndAssetsParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/ArtefactsAndAssets.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelBankingSoftwareParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/BankingSoftware.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelBerkeleyDBParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/BerkeleyDB.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelBigDataSystemParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/BigDataSystem.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelBusyboxParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/Busybox.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

}
