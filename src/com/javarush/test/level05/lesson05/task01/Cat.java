package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String), возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat
{
    public String name;
    public int age,weight,strength;

    public static void main(String[] args)
    {
        Cat cat= new Cat();
        cat.name="Java";
        cat.age=2;
        cat.weight=4;
        cat.strength=5;
    }

        }
