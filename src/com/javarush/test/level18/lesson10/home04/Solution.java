package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer>finalList=new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileReader fileReader1 = new FileReader(fileName1);
        FileReader fileReader2 = new FileReader(fileName2);
        while (fileReader1.ready())
        {
            list1.add(fileReader1.read());
        }
        while (fileReader2.ready())
        {
            list2.add(fileReader2.read());
        }
        fileReader1.close();
        fileReader2.close();
        FileWriter fileWriter = new FileWriter(fileName1);
        for (Integer a : list2)
        {
            finalList.add(a);
        }
        for (Integer a : list1)
        {
            finalList.add(a);
        }
        for (Integer a : finalList)
        {
            fileWriter.write(a);
        }
        fileWriter.close();
    }
}
