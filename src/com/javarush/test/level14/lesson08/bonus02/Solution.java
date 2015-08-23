package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a,b, max;
        a=Integer.parseInt(r.readLine());
        b=Integer.parseInt(r.readLine());
        ArrayList <Integer>list=new ArrayList<Integer>();
        int count=-1;
        if (a<b){
            max=b;
        }else {
            max=a;
        }
        if (a>0){
            if (b>0){
                for (int i=1; i<max+1; i++){

                    if (a%i==0){
                        if (b%i==0){
                            list.add(i);
                            count++;
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(count));
    }
}
