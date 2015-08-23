package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Dima on 28.06.2015.
 */
public class Tetris
{
    private Field field;
    private Figure figure;
    public static Tetris game;

    public Tetris(int width, int height)
    {
        field = new Field(width, height);
        figure = null;
    }

    public Figure getFigure()
    {
        return figure;
    }

    public Field getField()
    {

        return field;
    }

    public static void main(String[] args)
    {
        game=new Tetris(10,20);
        game.run();

    }
    public void run(){

    }
    public void step(){

    }
}
