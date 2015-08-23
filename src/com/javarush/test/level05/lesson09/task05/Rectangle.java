package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    int l,t,w,h;

    private Rectangle(int l, int t, int w, int h)
    {
        this.l=l;
        this.t=t;
        this.w=w;
        this.h=h;
    }


    private Rectangle(int l, int t)
    {
        this.l=l;
        this.t=t;
        this.w=0;
        this.h=0;
    }
    private Rectangle(int l, int t, int w)
    {
        this.l=l;
        this.t=t;
        this.w=w;
        this.h=this.w;
    }
    private Rectangle()
    {
        this.l=12;
        this.t=45;
        this.w=34;
        this.h=20;
    }


}
