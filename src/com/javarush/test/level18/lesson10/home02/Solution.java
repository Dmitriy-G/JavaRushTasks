package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        FileReader fr = new FileReader(args[0]);
        char[] list = new char[1000];
        int allcount = fr.read(list);
        int prcount=0;
        for (int i = 0; i < list.length; i++)
        {
            if (list[i]==' ')
            {
                prcount++;
            }
        }
        double result= (double)prcount/allcount*100;
        System.out.println(String.format("%.2f", (double)result));
    }
}
