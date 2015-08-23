package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list_gl = new ArrayList<String>();

        for(int i=0; i<5; i++){
            String S=reader.readLine();
            list_gl.add(S);
        }

        for(int i=0; i<5; i++){

            list_gl.add(0, (list_gl.get(i)));
        }

        for(int i=0; i<5; i++){
            int j = list_gl.size()-i-1;
            System.out.println(list_gl.get(j));
        }

    }
}
