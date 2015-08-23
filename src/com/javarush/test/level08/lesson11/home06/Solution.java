package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

        ArrayList<Human> child = new ArrayList<Human>();
        Human child1 = new Human("Женя", true, 5, new ArrayList<Human>() );
        child.add(child1);
        Human child2 = new Human("Вася", true, 4, new ArrayList<Human>() );
        child.add(child2);
        Human child3 = new Human("Петя", true, 3, new ArrayList<Human>() );
        child.add(child3);

        ArrayList<Human> parents1 = new ArrayList<Human>();
        Human father = new Human("Егор", true, 35, child);
        parents1.add(father);
        ArrayList<Human> parents2 = new ArrayList<Human>();
        Human mother = new Human("Марина", false, 30, child);
        parents2.add(mother);

        Human gf1 = new Human("Иван", true, 65, parents1);
        Human gf2 = new Human("Матвей", true, 63, parents2);
        Human gm1 = new Human("Тамара", false, 60, parents1);
        Human gm2 = new Human("Полина", false, 59, parents2);

        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);



    }


    public static class Human
    {
        private String name;
        private Boolean sex;
        private int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, Boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
