package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EquationRepository {

    private final String FILE_PATH = "src/main/resources/equations.json";

    private final JSONListLoader<EquationEntry> jsonHandler = new JSONHandler();

    private final File file = new File(FILE_PATH);

    private final List<EquationEntry> equations;

    {
        try {
            equations = jsonHandler.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToEquations(String equation, double result) throws IOException {
        equations.add(new EquationEntry(equations.size(),equation, result));
        jsonHandler.save(file, equations );
    }

}
