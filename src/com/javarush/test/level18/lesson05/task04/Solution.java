package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream= new FileInputStream(reader.readLine());
        FileOutputStream outputStream= new FileOutputStream(reader.readLine());
        ArrayList<Integer>bytes=new ArrayList<Integer>();

        while (inputStream.available()>0)
        {
        bytes.add(0,inputStream.read());
        }

        for (int i=0; i<bytes.size(); i++){
            outputStream.write(bytes.get(i));
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
