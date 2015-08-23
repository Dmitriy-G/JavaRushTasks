package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name,s1,s2,s3;
        int d,m,y;
        name=reader.readLine();
        s1=reader.readLine();
        s2=reader.readLine();
        s3=reader.readLine();
        d=Integer.parseInt(s1);
        m=Integer.parseInt(s2);
        y=Integer.parseInt(s3);
        System.out.println("Меня зовут"+" "+name);
        System.out.println("Я родился"+" "+y+"."+m+"."+d);
    }
}
