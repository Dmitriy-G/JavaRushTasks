package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Dima on 18.07.2015.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String S = "";
        try
        {
            S = reader.readLine();
            if (S.equalsIgnoreCase(res.getString("operation.EXIT")))
            {
                throw new InterruptOperationException();
            }

        }
        catch (IOException e)
        {
        }

        return S;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String test;
        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {
            test = readString();
            if (test.length() == 3)
                break;
            else
                writeMessage(res.getString("invalid.data"));

        }
        test = test.toUpperCase();
        return test;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] arr;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
        while (true)
        {
            String s = readString();
            arr = s.split(" ");
            try
            {
                int nominal = Integer.parseInt(arr[0]);
                int count = Integer.parseInt(arr[1]);
                if (count <= 0 || nominal <= 0)
                {
                    throw new Exception();
                }
                break;
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
        return arr;
    }


    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        Operation operation;
        while (true)
        {
            operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            break;
        }
        return operation;
    }


}
