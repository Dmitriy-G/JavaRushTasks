package com.javarush.test.level22.lesson09.task02;

import java.util.Iterator;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        String key="";String value="";
        StringBuilder S=new StringBuilder();
        int count=0;
        Iterator<Map.Entry<String,String>>iterator=params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String>pair=iterator.next();
            if (count!=0&pair.getValue()!=null){
                S.append("and"+" ");
            }
            key=pair.getKey();
            value=pair.getValue();
            if (value!=null)
            {
                S.append(key + " = " + "'" + value + "'"+" ");
            }
            count++;
        }
        return S;
    }
}
