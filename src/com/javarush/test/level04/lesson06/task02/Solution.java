package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String s1,s2,s3,s4;
        int a, b, c, d, x, y;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1=reader.readLine();
        s2=reader.readLine();
        s3=reader.readLine();
        s4=reader.readLine();
        a=Integer.parseInt(s1);
        b=Integer.parseInt(s2);
        c=Integer.parseInt(s3);
        d=Integer.parseInt(s4);
        if (a>b){
            x=a;
        }
        else
        {
            x=b;
        }
        if (c>d){
            y=c;
        }
        else
        {
            y=d;
        }
        if (x>y){
            System.out.println(x);
        }
        else
        {
            System.out.println(y);
        }


    }
}
