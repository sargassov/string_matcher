package org.sargassov.example.models;

import java.util.ArrayList;
import java.util.List;

public class SmartList extends ArrayList<String> {
    private int size;

    public SmartList(int size) {
        this.size = size;
    }

    public void addTo(String s){ // в отличие от кастомного метода add этот не принимает строк больше,
        // чем описано в input.txt
        try{
            if(s == null){
                throw new NullPointerException("Подана null-ссылка в метод add(WordList)");
            }
            if(super.size() == size)
                throw new ArrayIndexOutOfBoundsException("Подано больше слов чем " + size);

        } catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        add(s);
    }

}
