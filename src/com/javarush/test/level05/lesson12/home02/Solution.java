package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

import com.sun.org.apache.xpath.internal.SourceTree;

public class Solution
{
    public static void main(String[] args)
    {
        // Создай по два объекта каждого класса тут
        Man man1=new Man();
        man1.name="s ";
        man1.address="a";
        man1.age=1;

        Man man2=new Man();
        man2.name=" s";
        man2.address="s";
        man2.age=1;



        Woman woman1=new Woman();
        woman1.name=" f";
        woman1.address="";
        woman1.age=1;


        Woman woman2=new Woman();
        woman2.name="d ";
        woman2.address="f";
        woman2.age=1;





        // Выведи их на экран тут
    System.out.println(man1.name+" "+man1.age+" "+man1.address);
    System.out.println(man2.name+" "+man2.age+" "+man2.address);
    System.out.println(woman1.name+" "+woman1.age+" "+woman1.address);
    System.out.println(woman2.name+" "+woman2.age+" "+woman2.address);
    }

      public static class Man
    {
        String name, address;
        int age;

        {
            this.name = name;
            this.address=address;
            this.age=age;
        }

    }
    public static class Woman
    {
        String name, address;
        int age;

        {
            this.name = name;
            this.address=address;
            this.age=age;
        }
    }
}
