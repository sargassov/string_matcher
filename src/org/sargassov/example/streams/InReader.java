package org.sargassov.example.streams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InReader {
    private static Path path;
    private List<String> dataList;

    public InReader(String s) {

        try{
            if(s == null){
                throw new NullPointerException("Подана null-ссылка в метод конструктор(InReader)");
            }
        }  catch (NullPointerException e){
            e.printStackTrace();
            System.exit(-1);
        }

        dataList = new ArrayList<>();
        path = Paths.get(s);

    }

    public List<String> readFromFile(){
        try{
            if(!Files.exists(path)){
                throw new FileNotFoundException("input.txt не найден");
            }
            dataList = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return dataList;
    }

}
