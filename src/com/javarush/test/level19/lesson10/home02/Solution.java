package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String s, resultString="";
        double maxValue = 0;
        int sovp = 0;
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
            if (sovp == 0)
            {
                result.put(key, value);
            }
            sovp = 0;
        }
        fileReader.close();
        for (Map.Entry<String, Double> entry : result.entrySet())
        {
            if (entry.getValue() > maxValue)
            {
                maxValue=entry.getValue();
                resultString=entry.getKey();
            }
        }
        System.out.println(resultString);
    }
}
