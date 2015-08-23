package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String,String> map=new HashMap<String,String>();
        map.put("vanj","bostonj");
        map.put("vansf","bostondsf");
        map.put("vanss","bostonff");
        map.put("vands","bostodvdv");
        map.put("vansbbx","bostoeterij");
        map.put("vazzzzv","bostonzvzv");
        map.put("vantutuer","bostonwrwer");
        map.put("vanwsdbsdb","bostonessebseb");
        map.put("vanssxcxvxc","bostonzfseset");
        map.put("vansesetet","bostonsdgghryrdhdh");

return (HashMap)map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i = 0;
        for (Map.Entry<String,String> pair: map.entrySet())
        {

            String value = pair.getValue();
            if (value.equals(name)){
                i++;
            }
        }
        return i;
    }




    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        {
            int i = 0;
            for (Map.Entry<String,String> pair: map.entrySet())
            {

                String value = pair.getKey();
                if (value.equals(familiya)){
                    i++;
                }
            }
            return i;
        }


    }
}
