package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Dima on 09.02.2016.
 */
public class UniversityPerson
{
    private University university;
    private String name;
    private int age;


    public UniversityPerson(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void printData()
    {
        System.out.println(getPosition() + ": " + this.getName());
    }


    public void setUniversity(University university)
    {
        this.university = university;
    }

    public University getUniversity()
    {
        return university;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getPosition()
    {
        return null;
    }
}

