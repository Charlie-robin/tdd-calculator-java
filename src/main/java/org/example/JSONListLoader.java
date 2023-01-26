package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JSONListLoader<T> {

    List<T> load(File file) throws IOException;

    void save( File file, List<T> list) throws IOException;

}
