package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    int t,l,w,h;

    public void initialize (int t, int l,int w, int h)
    {
        this.t = t;
        this.l = l;
        this.w = w;
        this.h = h;
    }
    public void initialize (int t, int l)
    {
        this.t = t;
        this.l = l;
        this.w = 0;
        this.h = 0;
    }
    public void initialize (int t, int l,int w)
    {
        this.t = t;
        this.l = l;
        this.w = w;
        this.h = this.w;
    }
    public void initialize ()
    {
        this.t = 12;
        this.l = 15;
        this.w = 25;
        this.h = 12;
    }

}
