package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("fsdsdfs", "JUNE");
        map.put("dgsddhshsdh" ,"JUNE");
        map.put("sdgsdgsdg","DGFGF");
        map.put("hfhrrh", "JUNE");
        map.put("sefsgshh", "OCTOBER");
        map.put("dsgryr", "JUNE");
        map.put("drgdrgddhr", "JUNE");
        map.put("drgdrrhrege", "JUNE");
        map.put("wefewgwhh", "JUNE");
        map.put("esfsgeshg", "JUNE");
        return map;


    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        HashMap<String, String> map2 = new HashMap<String, String>(map); //дубликат map
        HashMap<String, String> map3 = new HashMap<String, String>(map); //дубликат map

        for (Map.Entry<String, String> pair : map2.entrySet())
        {
            map3.remove(pair.getKey());

            if (map3.containsValue(pair.getValue()))
            {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
        }


    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
