package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Dima on 05.05.2015.
 */
public class Mouse implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
