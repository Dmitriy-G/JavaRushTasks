package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception

    {
        String name1,name2;
        int x,y;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        name1=reader.readLine();
        name2=reader.readLine();
        x = name1.length();
        y = name2.length();

        if (name1.equals (name2)){
            System.out.println("Имена идентичны");
        }
else{
            if (x==y){
                System.out.println("Длины имен равны");
            }

        }


    }
}
