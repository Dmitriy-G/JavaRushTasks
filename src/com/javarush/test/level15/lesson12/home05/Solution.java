package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution()
    {
    }
    public Solution(String p, int i)
    {
    }
    public Solution(float k)
    {
    }
    protected Solution(Integer i, boolean n)
    {
    }
    protected Solution(Integer i, char w)
    {
    }
    protected Solution(Integer i, double w)
    {
    }
    private Solution(boolean b)
    {
    }
    private Solution(byte S)
    {
    }
    private Solution(String S)
    {
    }
    Solution(double g)
    {
    }
    Solution(char g)
    {
    }
    Solution(byte g, String S)
    {
    }
}

