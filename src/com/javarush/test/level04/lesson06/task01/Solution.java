package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String s1,s2;
        int a, b;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1=reader.readLine();
        s2=reader.readLine();
        a=Integer.parseInt(s1);
        b=Integer.parseInt(s2);
        if (a<b){
            System.out.println(a);
        }
        else
        {
            System.out.println(b);
        }



        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}