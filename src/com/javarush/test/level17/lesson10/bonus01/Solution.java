package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person;
        Date date = new Date();
        //start here - начни тут
        switch (args[0])
        {
            case "-c":
                if (args.length==4)
                {
                    try
                    {
                        date = df.parse(args[3]);
                    }
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    }
                    if (args[2].equals("м"))
                        allPeople.add(Person.createMale(args[1], date));
                    if (args[2].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(args[1], date));
                    }
                }

                if (args.length==5){
                    try
                    {
                        date = df.parse(args[4]);
                    }
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    }
                    if (args[3].equals("м"))
                        allPeople.add(Person.createMale(args[1]+" "+args[2], date));
                    if (args[3].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(args[1]+" "+args[2], date));
                    }
                }
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                if (args.length==5)
                {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    if (args[3].equals("м"))
                    {
                        person.setSex(Sex.MALE);
                    } else
                    {
                        person.setSex(Sex.FEMALE);
                    }

                    try
                    {
                        date = df.parse(args[4]);
                    }
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    }
                    person.setBirthDay(date);
                }
                if (args.length==6)
                {
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]+" "+args[3]);
                    if (args[4].equals("м"))
                    {
                        person.setSex(Sex.MALE);
                    } else
                    {
                        person.setSex(Sex.FEMALE);
                    }

                    try
                    {
                        date = df.parse(args[5]);
                    }
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    }
                    person.setBirthDay(date);
                }
                break;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
                break;
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                String sexS;
                if (person.getSex() == Sex.MALE)
                {
                    sexS = "м";
                } else
                {
                    sexS = "ж";
                }
                Date bd = person.getBirthDay();
                System.out.println(person.getName() + " " + sexS + " " + format1.format(bd));
                break;
        }
    }
}
