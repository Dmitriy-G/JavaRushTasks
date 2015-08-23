package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] numbers = new int[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < numbers.length-1; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if (numbers[i] > numbers[j])
                {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }


                    for (int k = 0; k <numbers.length ; k++)
                    {
                        System.out.println(numbers[k]);
                    }

    }
}