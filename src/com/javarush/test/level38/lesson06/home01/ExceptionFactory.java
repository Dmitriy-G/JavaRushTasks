package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Dima on 07.02.2016.
 */
public class ExceptionFactory
{
    public static Throwable getException(Enum e){

        if (e instanceof ExceptionApplicationMessage){
            String name1=e.name().substring(0,1);
            String name2=e.name().substring(1,e.name().length()).toLowerCase();
            return new Exception(name1.replace("_"," ")+name2.replace("_"," "));
        }

        if (e instanceof ExceptionDBMessage){
            String name1=e.name().substring(0,1);
            String name2=e.name().substring(1,e.name().length()).toLowerCase();
            return new RuntimeException(name1.replace("_"," ")+name2.replace("_"," "));
        }

        if (e instanceof ExceptionUserMessage){
            String name1=e.name().substring(0,1);
            String name2=e.name().substring(1,e.name().length()).toLowerCase();
            return new Error(name1.replace("_"," ")+name2.replace("_"," "));
        }

        return new IllegalArgumentException();
    }
}