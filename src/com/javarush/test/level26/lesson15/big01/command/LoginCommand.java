package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Dima on 24.07.2015.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards", Locale.ENGLISH);
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String userNumber = ConsoleHelper.readString();
            String userPIN = ConsoleHelper.readString();
            if (!userNumber.matches("\\d{12}") || !userPIN.matches("\\d{4}"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

            if (validCreditCards.containsKey(userNumber))
            {
                if (validCreditCards.getString(userNumber).equals(userPIN))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),userNumber));
                    break;
                } else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), userNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            } else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), userNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
        }
    }
}
