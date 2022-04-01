package org.sargassov.example;

import org.sargassov.example.streams.InReader;
import org.sargassov.example.streams.OutWriter;
import org.sargassov.example.utils.ExcessThrower;
import org.sargassov.example.utils.Matcher;

import java.util.List;

public class Main {
    private static final String inReaderFile = "src\\org\\sargassov\\example\\resourses\\input.txt";
    private static final String outWriterFile = "src\\org\\sargassov\\example\\resourses\\output.txt";


    public static void main(String[] args) {
        List<String> readFromFile = new InReader(inReaderFile).readFromFile(); //читаем текст из файла
        ExcessThrower thrower = new ExcessThrower(readFromFile); // выбрасываем пустые строки и числа
        Matcher matcher = new Matcher(thrower.ridOfExcess());
        List<String> responce = matcher.findMatch(); // находим наиболее похожие
        OutWriter writer = new OutWriter(outWriterFile);
        writer.writeToFile(responce); //пишем в файл
    }
}
