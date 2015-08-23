package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader=new FileReader(reader.readLine());
        FileWriter fileWriter=new FileWriter(reader.readLine());
        while (fileReader.ready())
        {
            list.add(fileReader.read());
        }

        for (int i=1; i<list.size(); i=i+2){
            fileWriter.write(list.get(i));
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
