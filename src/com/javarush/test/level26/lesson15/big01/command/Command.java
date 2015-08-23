package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Dima on 19.07.2015.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
