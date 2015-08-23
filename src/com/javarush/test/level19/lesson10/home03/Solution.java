package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нес3ольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        while (fileReader.ready())
        {
            Date date = new Date();
            String name = "";
            String[] str = fileReader.readLine().split(" ");
            for (int i = 0; i < str.length; i++)
            {
                try
                {
                    date = new SimpleDateFormat("dd MM yyyy").parse(str[i] + " " + str[i + 1] + " " + str[i + 2]);
                    break;
                }
                catch (ParseException e)
                {
                    name += str[i] + " ";
                }
            }
            PEOPLE.add(new Person(name.trim(), date));
        }
        fileReader.close();
    }

}
