package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        boolean B=false;
        String S;
        int Sum=0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!B){
            S=reader.readLine();

            if (S.equals("сумма")){
                B=true;
            }
            else
            {
                Sum=Sum+Integer.parseInt(S);
                B = false;
            }

            }
        System.out.println(Sum);

    }
}
