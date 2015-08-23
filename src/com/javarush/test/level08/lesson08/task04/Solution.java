
package com.javarush.test.level08.lesson08.task04;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("fsdsdfs", new Date("JUNE 1 1980"));
        map.put("dgsddhshsdh" ,new Date("JUNE 1 1980"));
        map.put("sdgsdgsdg", new Date("JUNE 1 1980"));
        map.put("hfhrrh", new Date("JUNE 1 1980"));
        map.put("sefsgshh", new Date("OCTOBER 1 1980"));
        map.put("dsgryr", new Date("JUNE 1 1980"));
        map.put("drgdrgddhr", new Date("JUNE 1 1980"));
        map.put("drgdrrhrege", new Date("JUNE 1 1980"));
        map.put("wefewgwhh", new Date("JUNE 1 1980"));
        map.put("esfsgeshg", new Date("JUNE 1 1980"));
        return map;

    }

    public static void removeAllSummerPeople(HashMap <String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Date> para = iterator.next();
            if (para.getValue().getMonth() > 4 && para.getValue().getMonth() < 8){
                iterator.remove();
            }

        }

    }

}