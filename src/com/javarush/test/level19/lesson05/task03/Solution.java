package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        String stroka = "";
        while(reader1.ready())
        {
            stroka = reader1.readLine();
            String[] array = stroka.split(" ");
            for (int i = 0; i < array.length; i++)
            {
                try{
                    int a = Integer.parseInt(array[i]);
                    writer.write(a+" ");
                } catch (Exception e) {}
            }

        }
        reader.close();
        reader1.close();
        writer.close();
    }
}