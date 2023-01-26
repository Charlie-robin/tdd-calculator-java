package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONHandler implements JSONListLoader<EquationEntry> {
    private final ObjectMapper objectMapper =  new ObjectMapper();

    {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @Override
    public List<EquationEntry> load(File file) throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<EquationEntry>>(){});
    }

    @Override
    public void save( File file, List<EquationEntry> list) throws IOException {
        objectMapper.writeValue(file, list);
    }


}
