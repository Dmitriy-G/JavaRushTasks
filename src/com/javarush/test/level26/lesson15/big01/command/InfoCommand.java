package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Dima on 19.07.2015.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean b = false;
        for (CurrencyManipulator pair : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (pair.hasMoney()){
                if (pair.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(pair.getCurrencyCode() + " - " + pair.getTotalAmount());
                    b = true;
                }
            }
        }
        if (b == false)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
