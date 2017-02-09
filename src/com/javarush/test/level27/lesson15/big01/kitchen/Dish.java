package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by Dima on 26.07.2015.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int duration)
    {
        this.duration = duration;
    }

    private int duration;

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString()
    {
        if (values().length == 0) {
            return "";
        }
        return Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}
