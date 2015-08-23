package com.javarush.test.level23.lesson13.big01;

/**
 * Created by Dima on 30.06.2015.
 */
public class SnakeSection
{
    private int x,y;
    public SnakeSection(int x,int y)
    {
        this.x = x;
        this.y=y;
    }

    public int getY()
    {
        return y;
    }

    public int getX()
    {

        return x;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SnakeSection)) return false;

        SnakeSection that = (SnakeSection) o;

        if (getX() != that.getX()) return false;
        return getY() == that.getY();

    }

    @Override
    public int hashCode()
    {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }
}
