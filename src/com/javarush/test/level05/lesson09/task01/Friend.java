package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    String name, v,p;
    private Friend (String name)
    {
        this.name = name;
    }
    private Friend (String name, String v)
    {
        this.name = name;
        this.v=v;
    }
    private Friend (String name, String v, String p)
    {
        this.name = name;
        this.v=v;
        this.p=p;
    }
}