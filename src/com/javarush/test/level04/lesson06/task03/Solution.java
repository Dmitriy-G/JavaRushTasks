package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String s1,s2,s3;
        int a, b, c, P1, P2, P3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1=reader.readLine();
        s2=reader.readLine();
        s3=reader.readLine();
        a=Integer.parseInt(s1);
        b=Integer.parseInt(s2);
        c=Integer.parseInt(s3);
        if (a>b)
        {
            if (a > c)
            {
                P1 = a;
                if (b > c)
                {
                    P2 = b;
                    P3 = c;
                } else
                {
                    P2 = c;
                    P3 = b;
                }
                ;
            } else
            {
                P1 = c;
                if (b > a)
                {
                    P2 = b;
                    P3 = a;
                } else
                {
                    P2 = a;
                    P3 = b;
                }
                ;
            }
        }

        else
        {
            if (b>c){
                P1=b;
                if (a>c){
                    P2=a;
                    P3=c;
                }
                else
                {
                    P2=c;
                    P3=a;
                };
            }
            else
            {
                P1=c;
                if (a>b){
                    P2=a;
                    P3=b;
                }
                else
                {
                    P2=b;
                    P3=a;
                };
            }

            };
        System.out.println(" "+P1+" "+P2+" "+P3);
        }

    }

