package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dima on 26.07.2015.
 */
public class Order
{
    public  Tablet tablet;
    public  List<Dish> dishes;
    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }


    public boolean isEmpty(){
        return dishes.isEmpty();
    }
    public int getTotalCookingTime(){
        int allTimes=0;
        for (Dish dish:dishes){
            allTimes=allTimes+dish.getDuration();
        }
        return allTimes;
    }
    @Override
    public String toString()
    {
        if (isEmpty())
        {
            return "";
        } else
        {
            return "Your order: " + dishes + " of " + tablet.toString();
        }
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public Tablet getTablet()
    {
        return tablet;
    }
}
