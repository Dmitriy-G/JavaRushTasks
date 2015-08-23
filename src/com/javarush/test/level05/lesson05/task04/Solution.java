package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

public class Solution {
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cat1.name = "SS";
        cat2.name = "S";
        cat3.name = "SSS";
        cat1.age=20;
        cat2.age=20;
        cat3.age=20;
        cat1.weight=50;
        cat2.weight=50;
        cat3.weight=50;
        cat1.strength=10;
        cat2.strength=10;
        cat3.strength=10;
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat() {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
