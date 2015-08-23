package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        FileReader fr= new FileReader(args[0]);
        char[]list=new char[1000];
        fr.read(list);
        int count=0;
        for (int i=0; i<list.length; i++){
            if ((list[i]>='A'&&list[i]<='Z')||(list[i]>='a'&&list[i]<='z')){
                count++;
            }
        }
        System.out.println(count);
    }
}
