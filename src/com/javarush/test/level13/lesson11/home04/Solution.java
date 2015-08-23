package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        OutputStream f1 = new FileOutputStream(reader.readLine());
        ArrayList<String> list=new ArrayList<String>();
        while (true){
            String S=reader.readLine();
            if (S.contains("exit")){
                list.add(S);
                list.add(" ");
                break;
            }
            else
            {
                list.add(S);
                list.add(" ");
            }
        }

        for (int i=0; i<list.size(); i++){
            f1.write(list.get(i).getBytes());
            f1.write("".getBytes());
        }

        f1.close();
        reader.close();


    }
}
