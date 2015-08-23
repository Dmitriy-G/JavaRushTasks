package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by Dima on 26.07.2015.
 */
public enum Dish
{
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString()
    {
        String resultString = Arrays.toString(Dish.values());
        return resultString.substring(resultString.indexOf("[")+1,resultString.lastIndexOf("]"));
    }
}
