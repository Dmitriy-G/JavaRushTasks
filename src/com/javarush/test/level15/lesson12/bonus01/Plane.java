package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Dima on 14.05.2015.
 */
public class Plane implements Flyable
{
    @Override
    public void fly()
    {

    }
    int countOfPassenger;
    public Plane(int countOfPassenger)
    {
        this.countOfPassenger = countOfPassenger;
    }
}
