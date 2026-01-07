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

    @Test
    public void testModelDOPLERToolsParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/DOPLERTools.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelDOPLERTools2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/DOPLERTools2.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelDellLaptopNotebookParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/DellLaptopNotebook.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelDeploymentAndConfigurationParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/DeploymentAndConfiguration.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelDissModelParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/DissModel.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelDissModel2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/DissModel2.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelFameDB2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/FameDB2.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelFeatureIDEParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/FeatureIDE.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelGPLMediumParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/GPLMedium.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelGPLSmallParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/GPLSmall.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelGPLTinyParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/GPLTiny.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelHICSSDMParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/HICSSDM.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelHICSSDM2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/HICSSDM2.csv");

        assertTrue("File does not exist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelMPPLParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/MPPL.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelMobilePhoneParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/MobilePhone.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelOnlineShopParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/OnlineShop.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelOnlineShop2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/OnlineShop2.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelPizzasParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/Pizzas.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelPizzas2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/Pizzas2.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelRFWParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/RFW.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelSafeBaliParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/SafeBali.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelSafeBali2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/SafeBali2.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelServiceAndFunctionalScopeParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/ServiceAndFunctionalScope.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelSimpleConditionsParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/SimpleConditions.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelSimplePizzaParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/SimplePizza.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelSimpleWaterfilterParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/SimpleWaterfilter.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelTestabilityAndMeasurmentReadinessParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/TestabilityAndMeasurmentReadiness.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelTightVNCParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/ThightVNC.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelUbuntu_14_10ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/Ubuntu_14_10.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelVMToolsParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/VMTools.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelVaMoSParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/VaMoS.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelVaMoS2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/VaMoS2.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelVaMoS3ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/VaMoS3.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelVacuumRobotParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/VacuumRobot.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelVacuumRobot2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/VacuumRobot2.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelWikiMatrixParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/WikiMatrix.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelWindows7ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/Windows7.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelWindows8ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/Windows8.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelWorkloadCharacterisationParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/WorkloadCharactisation.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModeleShopParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/eShop.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModeleShop2ParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/eShop2.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModeleShopFeatureIDEParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/eShopFeatureIDE.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModeleShopSPLOTParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/eShopSPLOT.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelebayParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/ebay.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelproduct_chesspieceParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/product_chesspiece.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelproduct_rockerswitchParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/product_rockerswitch.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelproduct_shiftforkParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/product_shiftfork.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelproduct_truckParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/product_truck.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelproduct_waterfilterParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/product_waterfilter.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

    @Test
    public void testModelserverParsingAndValidity() throws Exception {
        Path modelPath = Paths.get("modelEval/server.csv");

        assertTrue("File does not ecist: " + modelPath.toAbsolutePath(),
                Files.exists(modelPath));

        Dopler doplerModel = DoplerUtils.readDOPLERModelFromFile(modelPath);

        assertNotNull(doplerModel);
        assertFalse(doplerModel.getDecisions().isEmpty());

        boolean isSat = SolverUtils.checkSat(doplerModel.toSMTStream());

        assertTrue("Model is UNSAT", isSat);
    }

}
