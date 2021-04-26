package com.safrr.shape.reader;

import com.safrr.shape.exception.ConeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ConeReader {
    public String[] readFromFile(String filePath) throws ConeException {
        try {
            Path path = Path.of(filePath);
            try (Stream<String> stream = Files.lines(path)) {
                String[] validStrings = stream.filter(EllipseStringValidator::validateString)
                                        .toArray(String[]::new);

                if (validStrings.length == 0) {
                    throw new ConeException("File (" + filePath + ") does not contain any valid data");
                }
                return validStrings;
            }
        } catch (InvalidPathException | IOException e) {
            throw new ConeException("Unable to open file: " + filePath, e);
        }
    }
}
