package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {
    }
    //add your code here - добавь свой код тут
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public static void main(String[] args) {
        //Create 10 Cat-s here - создай 10 котов тут
        Cat cat1 = new Cat();  cats.add(cat1);
        Cat cat2 = new Cat();  cats.add(cat2);
        Cat cat3 = new Cat();  cats.add(cat3);
        Cat cat4 = new Cat();  cats.add(cat4);
        Cat cat5 = new Cat();  cats.add(cat5);
        Cat cat6 = new Cat();  cats.add(cat6);
        Cat cat7 = new Cat();  cats.add(cat7);
        Cat cat8 = new Cat();  cats.add(cat8);
        Cat cat9 = new Cat();  cats.add(cat9);
        Cat cat10 = new Cat(); cats.add(cat10);
        printCats();
    }

    public static void printCats() {
        //add your step 3 code here - добавь свой код для пункта 3 тут
        for (int i=0; i <cats.size(); i++)
        {
            System.out.println(cats.get(i));
        }
    }
}
