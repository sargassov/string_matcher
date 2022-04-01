package org.sargassov.example.utils;

import org.sargassov.example.models.SmartList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcessThrower {
    private List<String> unpreparedList;

    public ExcessThrower(List<String> unpreparedList) {
        if(unpreparedList == null){
            throw new NullPointerException("Поданы пустые входные данные в " + this.getClass().getName());
        }

        this.unpreparedList = unpreparedList;
    }

    public List<SmartList> ridOfExcess(){
        Iterator<String> it = unpreparedList.iterator();
        List<SmartList> exessLessList = new ArrayList<>();
        int currentSmartListCount = -1;

        while(it.hasNext()){ // выкидываем путсые строки, лишние пробелы, складываем в два листа
            String s = it.next().trim();
            if(s.equals(""))
                continue;
            try{
                int size = Integer.parseInt(s);
                exessLessList.add(new SmartList(size));
                ++currentSmartListCount;
            } catch (NumberFormatException e){
                exessLessList.get(currentSmartListCount).addTo(s);
            }
        }
        return exessLessList;
    }
}
