package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName =args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String>resultSortedList=new ArrayList<>();
        String s;
        int sovp=0;
        Map<String, Double> result = new HashMap<>();
        while ((s = fileReader.readLine()) != null)
        {
            String key = s.substring(0, s.lastIndexOf(" "));
            double value = Double.parseDouble(s.substring(s.lastIndexOf(" ")));
            for (Map.Entry<String, Double> entry : result.entrySet())
            {
                if (key.equals(entry.getKey()))
                {
                    entry.setValue(entry.getValue() + value);
                    sovp++;
                }
            }
            if (sovp==0)
            {
                result.put(key, value);
            }
            sovp=0;
        }
        fileReader.close();
        for (Map.Entry<String, Double> entry : result.entrySet())
        {
            resultSortedList.add(entry.getKey() + " " + entry.getValue());
        }
        Collections.sort(resultSortedList);
        for (String line:resultSortedList){
            System.out.println(line);
        }
    }
}
