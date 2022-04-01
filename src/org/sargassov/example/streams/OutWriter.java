package org.sargassov.example.streams;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class OutWriter {
    private static Path path;

    public OutWriter(String s) {
        path = Paths.get(s);
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToFile(List<String> strings){
        try {
            Files.write(path, strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
