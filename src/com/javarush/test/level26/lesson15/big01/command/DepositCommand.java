package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by Dima on 19.07.2015.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String S= ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator=CurrencyManipulatorFactory.getManipulatorByCurrencyCode(S);
        String []a=ConsoleHelper.getValidTwoDigits(S);
        try
        {
            int k = Integer.parseInt(a[0]);
            int l = Integer.parseInt(a[1]);
            currencyManipulator.addAmount(k, l);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), k * l, S));
        } catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
