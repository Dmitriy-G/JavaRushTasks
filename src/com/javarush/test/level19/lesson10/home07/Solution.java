package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        String line, result="";
        String lines[];
        while ((line = fileReader.readLine()) != null)
        {
            lines = line.split(" ");
            for (int i = 0; i < lines.length; i++)
            {
                if (lines[i].length() > 6)
                {
                    result=result+lines[i] + ",";
                }
            }
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(fileName2);
        fileWriter.write(result.substring(0,result.length()-1));
        fileWriter.close();
    }
}
