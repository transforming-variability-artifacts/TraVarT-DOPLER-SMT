package edu.kit.dopler.parser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.model.Dopler;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class ParserTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testParseAllModels() throws IOException {

        Path dir = Paths.get("modelEval");

        try (Stream<Path> stream = Files.walk(dir)) {
            stream.filter(Files::isRegularFile).forEach(file -> {

                try {
                    Dopler model = DoplerUtils.readDOPLERModelFromFile(file);
                    if (model.getDecisions().isEmpty()) {
                        collector.addError(new AssertionError(
                                "Decisions empty in file: " + file.getFileName()));
                    }

                } catch (Exception e) {
                    collector.addError(
                            new AssertionError("Parsing failed for file: "
                                    + file.getFileName(), e));
                }

            });
        }
    }
}