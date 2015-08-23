package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Dima on 19.07.2015.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String s = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
        int summa;
        Map<Integer, Integer> map;
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try
            {
                summa = Integer.parseInt(ConsoleHelper.readString());
                if (summa <= 0)
                {
                    throw new InterruptOperationException();
                }
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!manipulator.isAmountAvailable(summa))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try
            {
                map = manipulator.withdrawAmount(summa);
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            Collection<Integer> collection = map.keySet();
            for (Integer key : collection)
            {
                ConsoleHelper.writeMessage("\t" + key + " - " + map.get(key));
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"),summa,s));
            break;
        }
    }
}
