package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dima on 26.10.2015.
 */
public class BotClient extends Client
{
    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            String[] data = message.split(": ");
            if (data.length == 2)
            {
                String userName = data[0];
                String text = data[1];
                SimpleDateFormat simpleDateFormat = null;
                if (text.equals("дата"))
                {
                    simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                }
                if (text.equals("день"))
                {
                    simpleDateFormat = new SimpleDateFormat("d");
                }
                if (text.equals("месяц"))
                {
                    simpleDateFormat = new SimpleDateFormat("MMMM");
                }
                if (text.equals("год"))
                {
                    simpleDateFormat = new SimpleDateFormat("YYYY");
                }
                if (text.equals("время"))
                {
                    simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                }
                if (text.equals("час"))
                {
                    simpleDateFormat = new SimpleDateFormat("H");
                }
                if (text.equals("минуты"))
                {
                    simpleDateFormat = new SimpleDateFormat("m");
                }
                if (text.equals("секунды"))
                {
                    simpleDateFormat = new SimpleDateFormat("s");
                }

                Date date = Calendar.getInstance().getTime();
                if (simpleDateFormat != null)
                {
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(date));
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        return "date_bot_" + (int) (Math.random() * 99);
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
