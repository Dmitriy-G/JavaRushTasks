package com.javarush.test.level30.lesson02.task01;



/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s)
    {
        int ch=0;
        char[]arrCh=s.toCharArray();
        for (int i=0; i<1; i++)
        {
            if (arrCh[i]=='0'&& arrCh[i+1]=='x')
            {
                ch = Integer.parseInt(s.replaceAll("x", ""), 16);
                break;
            }
            if (arrCh[i]=='0'&& arrCh[i+1]=='b'){
                ch = Integer.parseInt(s.replaceAll("b", ""), 2);
                break;
            }
            if (arrCh[i]=='0'){
                ch = Integer.parseInt(s, 8);
                break;
            }
            ch = Integer.parseInt(s);
        }
        return ch+"";
    }
}
