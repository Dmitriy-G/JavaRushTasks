package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Dima on 09.02.2016.
 */
public class Soldier extends Human
{
    @Override
    public void live()
    {
        this.fight();
    }

    public void fight() {
    }
    public Soldier(String name, int age)
    {
        super(name, age);
    }
}
