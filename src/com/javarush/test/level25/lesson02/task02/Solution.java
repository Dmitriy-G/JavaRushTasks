package com.javarush.test.level25.lesson02.task02;


import java.util.LinkedList;
import java.util.List;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution
{
    public static enum Wheel
    {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car
    {
        protected List<Wheel> wheels;

        public Car()
        {
            //init wheels here
            try
            {
                if (loadWheelNamesFromDB().length != 4)
                    throw new IllegalArgumentException();

                wheels = new LinkedList<>();
                Wheel[] arr = Wheel.values();

                for (int i = 0; i < loadWheelNamesFromDB().length; i++)
                {
                    int count=0;
                    String s=arr[i].toString();
                    for (int j = 0; j < loadWheelNamesFromDB().length; j++)
                    {
                        if (loadWheelNamesFromDB()[j].equals(s))
                        {
                            wheels.add(arr[i]);
                        }else
                        {
                            if (count!=3)
                            {
                                count++;
                            }else
                            {
                                throw new IllegalArgumentException();
                            }
                        }
                    }
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.print("Это не машина");
            }
        }

        protected String[] loadWheelNamesFromDB()
        {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_RIGHT", "BACK_LEFT"};
        }
    }

    public static void main(String[] args)
    {
        Car car = new Car();
    }
}
