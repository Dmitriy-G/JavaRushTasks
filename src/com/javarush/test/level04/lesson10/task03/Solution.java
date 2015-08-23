package com.javarush.test.level04.lesson10.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i=0,n;
        String s1,s2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1=reader.readLine();
        s2=reader.readLine();
        n=Integer.parseInt(s2);
        while (i<n){
            System.out.println(s1);
            i++;
        }

    }
}
