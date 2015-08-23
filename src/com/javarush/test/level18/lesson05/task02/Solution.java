package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream= new FileInputStream(reader.readLine());
        ArrayList<Integer>str=new ArrayList<Integer>();
        int count=0;
        while (inputStream.available()>0){
            int c=inputStream.read();
            str.add(c);
            if (c==44){
                count++;
            }
        }
        reader.close();
        inputStream.close();
        System.out.println(count);
    }
}
