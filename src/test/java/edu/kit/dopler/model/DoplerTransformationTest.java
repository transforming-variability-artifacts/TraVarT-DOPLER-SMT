package edu.kit.dopler.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.*;
import java.util.stream.Stream;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.io.DoplerModelWriter;

import static org.junit.Assert.*;

public class DoplerTransformationTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testRoundTripCSVTransformation() throws Exception {

        Path dir = Paths.get("modelEval");

        File tempFile = tempFolder.newFile("roundtrip.csv");
        Path tempPath = tempFile.toPath();

        try (Stream<Path> stream = Files.walk(dir)) {

            stream.filter(Files::isRegularFile).forEach(file -> {

                try {
                    Dopler originalModel = DoplerUtils.readDOPLERModelFromFile(file);

                    DoplerModelWriter writer = new DoplerModelWriter();
                    writer.writeCSV(originalModel, tempPath);

                    Dopler rereadModel = DoplerUtils.readDOPLERModelFromFile(tempPath);

                    assertEquals(
                            originalModel.getDecisions().size(),
                            rereadModel.getDecisions().size());

                    if (!originalModel.getDecisions()
                            .equals(rereadModel.getDecisions())) {

                        collector.addError(new AssertionError(
                                "Roundtrip mismatch in file: "
                                        + file.getFileName()));
                    }

                } catch (Exception e) {
                    collector.addError(new AssertionError(
                            "Error processing file: "
                                    + file.getFileName(),
                            e));
                }
            });
        }
    }
}