package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Dima on 08.11.2015.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits == 0)
            amountPerOneDisplaying = 0;
        else
            amountPerOneDisplaying = initialAmount / hits;
    }

    public void revalidate()
    {
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;
        if (hits == 1) amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getHits()
    {
        return hits;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }
}
