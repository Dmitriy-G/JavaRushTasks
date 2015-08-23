package com.javarush.test.level14.lesson08.bonus01;

import java.lang.instrument.IllegalClassFormatException;
import java.util.*;
import java.util.prefs.InvalidPreferencesFormatException;


/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] arr={2,2,1};
            int i=arr[5];

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new Exception();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw null;

        } catch (Exception e)
        {
            exceptions.add(e);
        }


        try
        {
            throw new IllegalThreadStateException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }



        try
        {
            throw new EmptyStackException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalMonitorStateException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalAccessException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalArgumentException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalClassFormatException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }

}
