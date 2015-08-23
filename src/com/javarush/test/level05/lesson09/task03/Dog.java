package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
        String name, r, c;

        private Dog(String name)
        {
            this.name = name;
        }
    private Dog(String name, String r)
    {
        this.name = name;
        this.r=r;
    }
    private Dog(String name, String r, String c)
    {
        this.name = name;
        this.r=r;
        this.c=c;
    }




}
