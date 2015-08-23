package com.javarush.test.level08.lesson11.home09;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        isDateOdd("JANUARY 4 2013");

    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        DateFormat now = new SimpleDateFormat("MMM dd yyyy", Locale.US);
        Date nowd = now.parse(date);


        Date YearStartTime=new Date();
        YearStartTime.setYear(nowd.getYear());
        YearStartTime.setHours(0);
        YearStartTime.setMonth(0);
        YearStartTime.setMinutes(0);
        YearStartTime.setSeconds(0);
        YearStartTime.setDate(1);




        long msD=nowd.getTime()-YearStartTime.getTime();
        long msDay=24*60*60*1000;
        int DayCount=(int)(msD/msDay);
        boolean b;
        if (DayCount%2==0){
           b=false;
        }
        else {
            b=true;
        }
       return b;

    }
}
