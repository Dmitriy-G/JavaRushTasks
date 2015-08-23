package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int x,y,z;
        String s1,s2,s3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1=reader.readLine();
        s2=reader.readLine();
        s3=reader.readLine();
        x=Integer.parseInt(s1);
        y=Integer.parseInt(s2);
        z=Integer.parseInt(s3);

        if (x<y&x<z)
        {
            if (z < y)
            {
                System.out.println(z);
            } else
            {
                System.out.println(y);
            }
        }



        if (z<y&&z<x){
            if (x<y){
                System.out.println(x);}
            else{
                System.out.println(y);}
        }

        if (y<x&&y<z){
            if (x<z){
                System.out.println(x);
            }
            else
            {
                System.out.println(z);
            }
        }
    }
}
