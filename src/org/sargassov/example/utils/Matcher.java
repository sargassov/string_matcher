package org.sargassov.example.utils;

import org.sargassov.example.models.SmartList;

import java.util.*;
import java.util.stream.Collectors;

public class Matcher {
    private SmartList sm1;
    private SmartList sm2;

    public Matcher(List<SmartList> listOfSmartL) {
        if(listOfSmartL.get(0).size() >= listOfSmartL.get(1).size()){
            sm1 = listOfSmartL.get(0);// для удобства сравниваем больший пул строк и меньшим
            sm2 = listOfSmartL.get(1);
        } else {
            sm1 = listOfSmartL.get(1);
            sm2 = listOfSmartL.get(0);
        }
    }

    public List<String> findMatch(){
        List<StringBuilder> responce = new ArrayList<>();

        for (int x = 0; x < sm1.size(); x++) {
            responce.add(new StringBuilder());
            responce.get(x).append(sm1.get(x)).append(":");

            if(sm1.size() == 1 && sm2.size() == 1) // елси в обоих листах по одной строке не начинаем сравнение
                responce.get(x).append(sm2.get(0));
            else{
                int maxCompareVal = 0, selected = -1;

                for (int y = 0; y < sm2.size(); y++) {
                    int curCompareVal = compareWords(sm1.get(x), sm2.get(y)); // метод вернет количество совпавших символов подряд при сравнении двух строк
                    if(curCompareVal > maxCompareVal) {
                        maxCompareVal = curCompareVal;
                        selected = y;
                    }
                }
                if(selected == -1)
                    responce.get(x).append("?");
                else{
                    responce.get(x).append(sm2.get(selected));
                    sm2.remove(selected);
                }
            }
        }
        return responce.stream().map(r -> r.toString()).collect(Collectors.toList());
    }


    private int compareWords(String s1, String s2){
        String leftWord, rightWord;

        if(s1.length() >= s2.length()){ //сравниваем для удобства меньшие строки с большой
            leftWord = leftSpace(s1).toLowerCase(Locale.ROOT);
            rightWord = leftSpace(s2).toLowerCase(Locale.ROOT);
        } else {
            leftWord = leftSpace(s2);
            rightWord = leftSpace(s1);
        }
        for (int a = rightWord.length(); a > 2; a--) { // вхождение строки в строку начинаем искать с полного соответствия
            // затем убираем по одному символу и ищем вхождения части от строки
            for (int b = 0; b <= rightWord.length() - a; b++) {
                String s = rightWord.substring(b, b + a);
                if(leftWord.contains(s))
                    return a;
            }
        }
        return 0;
    }

    private String leftSpace(String s){
        return s.replaceAll(" ", "");
    }

}
