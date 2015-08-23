package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
   String  name2,p2;
    int v2;

    public void initialize(String name)
    {
        this.name2=name;
    }

    public void initialize(String name, String p){
        this.p2=name+p;
    }

    public void initialize(String name, String p, int v){
        this.p2=name+p+v;
    }



}

