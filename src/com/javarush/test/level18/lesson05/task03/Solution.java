package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream1= new FileInputStream(reader.readLine());
        FileOutputStream outputStream2=new FileOutputStream(reader.readLine());
        FileOutputStream outputStream3=new FileOutputStream(reader.readLine());

        byte[] buffer1 = new byte[inputStream1.available()/2];
        byte[] buffer2 = new byte[inputStream1.available()/2 + inputStream1.available()%2];

        outputStream3.write(buffer1, 0, inputStream1.read(buffer1));
        outputStream2.write(buffer2, 0, inputStream1.read(buffer2));

        reader.close();
        inputStream1.close();
        outputStream2.close();
        outputStream3.close();

    }
}
