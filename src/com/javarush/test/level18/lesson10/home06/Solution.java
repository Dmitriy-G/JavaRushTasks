package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> listAscii = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String s;
        int j = 0;
        while ((s = fileReader.readLine()) != null)
        {
            if (j > 0)
            {
                listAscii.add('\n' + 0);
            }
            char[] arrCh = s.toCharArray();
            for (int i = 0; i < arrCh.length; i++)
            {
                listAscii.add(arrCh[i] + 0);
            }
            j++;
        }
        fileReader.close();
        Collections.sort(listAscii);
        int tempAncii = listAscii.get(0), count = 0;
        for (int i = 0; i < listAscii.size(); i++)
        {
            if (tempAncii != listAscii.get(i))
            {
                System.out.println((char) tempAncii + " " + count);
                tempAncii = listAscii.get(i);
                count = 0;
            }
            count++;
            if (i == listAscii.size() - 1)
            {
                System.out.println((char) tempAncii + " " + count);
            }
        }
    }
}
