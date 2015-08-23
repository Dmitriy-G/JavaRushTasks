package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    public Money(double amount)
    {
    }

    protected Money()
    {
    }


    public abstract String getCurrencyName();

    private double p=getAmount();


    public  double getAmount(){
       return p;
    }

}

