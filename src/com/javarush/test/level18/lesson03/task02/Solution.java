package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream= new FileInputStream(reader.readLine());
        int bytes=0, maxbyte=bytes;
        while (inputStream.available()>0){
            bytes=inputStream.read();
            if (maxbyte==0){
                maxbyte=bytes;
            }
            if (bytes<maxbyte){
                maxbyte=bytes;
            }
        }
        System.out.println(maxbyte);
        reader.close();
        inputStream.close();
    }
}
