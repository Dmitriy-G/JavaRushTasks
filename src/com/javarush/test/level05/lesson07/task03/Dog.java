package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name;
    int r, c;

    public void initialize (String name){
        this.name=name;
    }
    public void initialize (String name, int r){
        this.name=name;
        this.r=r;
    }
    public void initialize (String name, int r, int c){
        this.name=name;
        this.r=r;
        this.c=c;
    }


}
