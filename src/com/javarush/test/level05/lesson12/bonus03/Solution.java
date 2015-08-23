package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int  k,n,maximum;
        n =  Integer.parseInt(reader.readLine());
        if (n >= 0)
        {

            k =Integer.parseInt(reader.readLine());
            maximum = k;
            for (int i = 1; n == i; i++)

            {
                k = Integer.parseInt(reader.readLine());
                if (k > maximum)
                    maximum = k;
            }


            System.out.println(maximum);
        }

    }

}