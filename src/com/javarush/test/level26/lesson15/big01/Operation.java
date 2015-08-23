package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Dima on 18.07.2015.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        if(i < 1 || i > 4)
            throw new IllegalArgumentException();

        switch (i)
        {
            case 0:
                return Operation.LOGIN;
            case 1:
                return Operation.INFO;
            case 2:
                return Operation.DEPOSIT;
            case 3:
                return Operation.WITHDRAW;
            case 4:
                return Operation.EXIT;
        }

        return Operation.EXIT;
    }
}
