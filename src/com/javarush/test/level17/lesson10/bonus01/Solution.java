package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        //start here - начни тут
        String allParameters = "-c Миронов м 15/04/1990";
        String[] parameters = allParameters.split(" ");
        Date date = null;
        if (parameters[0].equals("-c"))
        {
            String name = parameters[1];
            String sex = parameters[2];
            String[] dates = parameters[3].split("/");
            SimpleDateFormat d = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            try
            {
                date = d.parse(dates[0]+" "+dates[1]+" "+dates[2]);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            peopleCreate(name, sex, date);
        }
        if (parameters[0].equals("-u"))
        {
            int id = Integer.parseInt(parameters[1]);
            String name = parameters[2];
            String sex = parameters[3];
            String[] dates = parameters[4].split("/");
            SimpleDateFormat d = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            try
            {
                date = d.parse(dates[0]+" "+dates[1]+" "+dates[2]);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            peopleUpdate(id, name, sex, date);
        }
        if (parameters[0].equals("-d"))
        {
            peopleDelete(Integer.parseInt(parameters[1]));
        }
        if (parameters[0].equals("-i"))
        {
            peopleInfo(Integer.parseInt(parameters[1]));
        }
        for (Person people : allPeople)
        {
            System.out.println(people.getName() + " " + people.getSex() + " " + people.getBirthDay());
        }
    }

    public static void peopleCreate(String name, String sex, Date bd)
    {
        if (sex.equals("м") || sex.equals("M"))
        {
            allPeople.add(Person.createMale(name, bd));
        } else
        {
            allPeople.add(Person.createFemale(name, bd));
        }
    }

    public static void peopleUpdate(int id, String name, String sex, Date bd)
    {
        if (sex.equals("m"))
        {
            allPeople.add(id, Person.createMale(name, bd));
        } else
        {
            allPeople.add(id, Person.createFemale(name, bd));
        }
    }

    public static void peopleDelete(int id)
    {
        allPeople.remove(id);
    }

    public static void peopleInfo(int id)
    {
        System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + allPeople.get(id).getBirthDay());
    }
}
