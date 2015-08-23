package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Dima on 14.07.2015.
 */
public class LoggingStateThread extends Thread
{
    private Thread thread;

    public LoggingStateThread(Thread thread)
    {
        this.thread=thread;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (thread.getState() != state){
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}
