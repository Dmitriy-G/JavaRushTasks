package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        BufferedReader inputStream = new BufferedReader(new FileReader(reader.readLine()));

        ArrayList<Integer>list=new ArrayList<Integer>();

        ArrayList<Character>sm=new ArrayList<Character>();

        while(inputStream.ready())
        {
            int i = Integer.parseInt(inputStream.readLine());
            list.add(i);
        }


        ArrayList<Integer>ch=new ArrayList<Integer>();

        for (int i=0; i<list.size(); i++){
            if (list.get(i)%2==0){
              ch.add(list.get(i));
            }
    }

        Collections.sort(ch);
        for (int i=0; i<ch.size(); i++){
            System.out.println(ch.get(i));
        }



        inputStream.close();
        reader.close();
    }
}
