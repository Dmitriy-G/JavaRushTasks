package com.javarush.test.level24.lesson14.big01;

/**
 * Created by Dima on 10.07.2015.
 */
public class Brick extends BaseObject
{
    public Brick(double x, double y)
    {
        super(x,y,3);
    }
    public Brick(double x, double y, double radius)
    {
        super(x, y, radius);
    }

    @Override
    public void draw(Canvas canvas)
    {

    }

    @Override
    public void move()
    {

    }

}
