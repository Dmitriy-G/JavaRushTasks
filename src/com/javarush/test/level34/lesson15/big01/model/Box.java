package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Dima on 04.02.2016.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX()+x);
        this.setY(this.getY()+y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.blue);
        graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
