package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    String x, y, r, w,c;

    private Circle(String x, String y, String r)
{
    this.x = x;
    this.y=y;
    this.r=r;
}
    private Circle(String x, String y, String r, String w)
    {
        this.x = x;
        this.y=y;
        this.r=r;
        this.w=w;
    }
    private Circle(String x, String y, String r, String w, String c)
    {
        this.x = x;
        this.y=y;
        this.r=r;
        this.w=w;
        this.c=c;
    }


}
