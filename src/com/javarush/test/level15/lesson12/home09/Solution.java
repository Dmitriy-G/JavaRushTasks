package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        boolean t = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> parameters = new ArrayList<String>();
        ArrayList<String> pvalues = new ArrayList<String>();
        ArrayList<Double> dvalues = new ArrayList<Double>();
        ArrayList<String> svalues = new ArrayList<String>();
        ArrayList<Character> k = new ArrayList<Character>();
        int p = 0;
        String S = reader.readLine();
        for (int i = 0; i < S.length(); )
        {
            Character c = S.charAt(i);
            if (c.equals("?".charAt(0)))
            {
                p = i;
                break;
            }
            i++;
            if (i == S.length())
            {
                t = true;
            }
        }
        if (t == false)
        {
            for (int i = p + 1; i < S.length(); )
            {
                Character c;
                c = (S.charAt(i));
                if (c.equals("&".charAt(0)))
                {
                    String SS = "";
                    String SSS = "";
                    boolean b = false;
                    for (int j = 0; j < k.size(); j++)
                    {
                        if (SS.equals("obj"))
                        {
                            b = true;
                            parameters.add(SS);
                            SS = "";
                            continue;
                        } else
                        {
                            if (k.get(j).equals("=".charAt(0)))
                            {
                                break;
                            }
                        }
                        if (b == false)
                        {
                            SS = SS + k.get(j);
                        } else
                        {
                            SSS = SSS + k.get(j);
                        }
                    }
                    parameters.add(SS);
                    if (b == true)
                    {
                        pvalues.add(SSS);
                    }
                    k.clear();
                } else
                {
                    k.add(c);
                }
                i++;
                if (i == S.length())
                {
                    String SS = "";
                    String SSS = "";
                    boolean b = false;
                    for (int j = 0; j < k.size(); j++)
                    {
                        if (SS.equals("obj"))
                        {
                            b = true;
                            continue;
                        } else
                        {
                            if (k.get(j).equals("=".charAt(0)))
                            {
                                break;
                            }
                        }
                        if (b == false)
                        {
                            SS = SS + k.get(j);
                        } else
                        {
                            SSS = SSS + k.get(j);
                        }
                    }
                    parameters.add(SS);
                    if (b == true)
                    {
                        pvalues.add(SSS);
                    }
                    k.clear();
                }
            }
        }


            for (int i = 0; i < pvalues.size(); i++)
            {
                try
                {
                    Double pp = Double.parseDouble(pvalues.get(i));
                    dvalues.add(pp);
                }
                catch (Exception e)
                {
                    svalues.add(pvalues.get(i));
                }
            }


            String str = "";
            for (int i = 0; i < parameters.size(); i++)
            {
                str = str + parameters.get(i) + " ";
            }
            System.out.println(str);
            for (int i = 0; i < dvalues.size(); i++)
            {
                alert(dvalues.get(i));
            }
            for (int i = 0; i < svalues.size(); i++)
            {
                alert(svalues.get(i));
            }
        }


    public boolean b=false;

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
