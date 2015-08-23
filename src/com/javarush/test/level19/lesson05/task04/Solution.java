package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileReader = new FileInputStream(reader.readLine());
        FileWriter fileWriter=new FileWriter(reader.readLine());
        byte[] str = new byte[fileReader.available()]; // считываем
        fileReader.read(str);
        String s=new String(str);
        fileWriter.write(s.replaceAll("[.]","!"));
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
