package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dima on 08.02.2016.
 */
public class MyThread extends Thread
{
    private static AtomicInteger counter=new AtomicInteger(1);

    public MyThread()
    {
        setPriority(countThread());
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority(countThread());
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPriority(countThread());
    }

    public MyThread(String name)
    {
        super(name);
        setPriority(countThread());
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority(countThread());
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group,name);
        setPriority(countThread());
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setPriority(countThread());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPriority(countThread());
    }

    public synchronized int countThread()
    {
        int i;
        if (counter.get() < 10)
        {
            i = counter.getAndIncrement();
        } else
        {
            i = counter.get();
            counter.set(1);
        }
        return i;
    }
}
