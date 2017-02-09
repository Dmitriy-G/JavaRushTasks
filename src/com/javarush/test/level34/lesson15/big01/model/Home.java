package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Dima on 04.02.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        this.setHeight(2);
        this.setWidth(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.red);
        graphics.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
