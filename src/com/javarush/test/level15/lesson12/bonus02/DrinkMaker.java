package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Dima on 14.05.2015.
 */
public abstract class DrinkMaker
{
   abstract void getRightCup();
   abstract void putIngredient();
    abstract void pour();
    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
