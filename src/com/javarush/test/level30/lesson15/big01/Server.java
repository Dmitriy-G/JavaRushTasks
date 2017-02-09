package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Dima on 21.10.2015.
 */
public class Server
{

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        Set<Map.Entry<String, Connection>> entrySet = connectionMap.entrySet();

        for (Map.Entry<String, Connection> pair : entrySet)
        {
            try
            {
                pair.getValue().send(message);

            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение");
                System.out.println(message);
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message message = connection.receive();
            String userName;
            if (message.getType() == MessageType.USER_NAME)
            {
                userName = message.getData();
            } else
            {
                userName = serverHandshake(connection);
            }
            if (userName == null)
            {
                userName = serverHandshake(connection);
            }
            if (userName.equals(""))
            {
                userName = serverHandshake(connection);
            }
            Set<Map.Entry<String, Connection>> entrySet = connectionMap.entrySet();
            for (Map.Entry<String, Connection> pair : entrySet)
            {
                if (pair.getKey().equals(userName))
                {
                    userName = serverHandshake(connection);
                    break;
                }
            }
            connectionMap.put(userName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            Set<Map.Entry<String, Connection>> entrySet = connectionMap.entrySet();

            for (Map.Entry<String, Connection> pair : entrySet)
            {
                String newUserName = pair.getKey();
                if (!userName.equals(newUserName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, newUserName));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else
                {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }


        @Override
        public void run()
        {
         ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом" + " " + socket.getRemoteSocketAddress());
            Connection connection=null;
            String userName=null;
            try
            {
                connection=new Connection(socket);
                userName=serverHandshake(connection);
                connectionMap.put(userName, connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (IOException e)
            {
                if (userName!=null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом "+socket.getRemoteSocketAddress());
            }
            catch (ClassNotFoundException e)
            {
                if (userName!=null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом "+socket.getRemoteSocketAddress());
            }finally
            {
                try
                {
                    connection.close();
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом "+socket.getRemoteSocketAddress()+" закрыто");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args)
    {
        ServerSocket serverSocket = null;
        try
        {
            int port = ConsoleHelper.readInt();
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true)
            {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        }
        catch (Exception ignore)
        {
            ConsoleHelper.writeMessage("Ошибка");
        }
        finally
        {
            try
            {
                serverSocket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
