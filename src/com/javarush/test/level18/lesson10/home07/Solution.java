package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int id = Integer.parseInt(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line, sId;
        while ((line = fileReader.readLine()) != null)
        {
            sId="";
            char[] b = line.toCharArray();
            for (int i = 0; i < b.length; i++)
            {
                sId = sId + b[i];
                if (b[i] == ' ')
                {
                    break;
                }
            }
            if (Integer.parseInt(sId.trim()) == id)
            {
                System.out.println(line);
                break;
            }

        }
        fileReader.close();
    }
}
