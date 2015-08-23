package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader1.readLine()) != null) {
            lines.add(line);
        }
        for (int i=0; i<lines.size(); i++)
        {
            StringBuilder st = new StringBuilder(lines.get(i));
            st.reverse();
            line = st.toString();
            System.out.println(line);
        }
        reader.close();
        reader1.close();
    }
}
