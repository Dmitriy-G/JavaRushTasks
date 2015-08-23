package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Dima on 05.05.2015.
 */
public class Computer
{
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;



    public Computer()
    {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }



    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
