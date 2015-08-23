package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Dima on 07.05.2015.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public USD()
    {

    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
