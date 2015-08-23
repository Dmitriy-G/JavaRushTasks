package com.javarush.test.level18.lesson10.home10;

    /* Собираем файл
    Собираем файл из кусочков
    Считывать с консоли имена файлов
    Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
    Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
    В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
    В него переписать все байты из файлов-частей используя буфер.
    Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
    Закрыть потоки. Не использовать try-with-resources
    Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
    */


import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> map = new TreeMap<Integer, String>();
        String output;
        String fileName;
        String temp = "";
        while (!(fileName = reader.readLine()).equals("end"))
        {
            int i = Integer.parseInt(fileName.substring(fileName.lastIndexOf(".part") + 5));
            map.put(i, fileName);
            if (!fileName.equals("end"))
            {
                temp = fileName;
            }
        }
        output = temp.substring(0, temp.lastIndexOf(".part"));
        FileOutputStream fileOutputStream = new FileOutputStream(output);
        for (Map.Entry<Integer, String> pair : map.entrySet())
        {
            FileInputStream fileInputStream = new FileInputStream(pair.getValue());
            byte[] buffer = new byte[1024];
            while (fileInputStream.available() > 0)
            {
                int count = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, count);
            }
            fileInputStream.close();
        }
        reader.close();
        fileOutputStream.close();
    }
}
