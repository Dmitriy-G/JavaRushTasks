package com.javarush.test.level27.lesson15.big01.statistic.event;

/**
 * Created by Dima on 20.06.2016.
 */
public interface EventDataRow
{
    EventType getType();
    java.util.Date getDate();
    int getTime();
}
