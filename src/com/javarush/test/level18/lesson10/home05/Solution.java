package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileName1));
        ArrayList<String[]> listArrays = new ArrayList<>();
        ArrayList<Long> finalList = new ArrayList<>();
        String line;
        while ((line = readerFile.readLine()) != null)
        {
            listArrays.add(line.split(" "));
        }
        readerFile.close();
        for (int i = 0; i < listArrays.size(); i++)
        {
            for (int j = 0; j < listArrays.get(i).length; j++)
            {
                String[] lin = listArrays.get(i);
                finalList.add(((int)Math.round(Double.parseDouble(lin[j]) * 1L)  ) / 1L);
            }
        }
        FileWriter fileWriter=new FileWriter(fileName2);
        for (Long l : finalList)
        {
            fileWriter.write(l+" ");
        }
        fileWriter.close();
    }
}
