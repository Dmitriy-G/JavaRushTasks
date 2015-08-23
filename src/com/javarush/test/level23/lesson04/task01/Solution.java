package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];
        Solution solution = new Solution();
        result[0]= new Solution();
        result[0].innerClasses[0] = solution.new InnerClass();
        result[0].innerClasses[1] = solution.new InnerClass();

        result[1]= new Solution();
        result[1].innerClasses[0] = solution.new InnerClass();
        result[1].innerClasses[1] = solution.new InnerClass();


        return result;
    }
}
