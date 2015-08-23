package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set1 = new HashSet<Integer>();
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        set1.add(7);
        set1.add(8);
        set1.add(9);
        set1.add(10);
        set1.add(11);
        set1.add(12);
        set1.add(13);
        set1.add(14);
        set1.add(15);
        set1.add(16);
        set1.add(17);
        set1.add(18);
        set1.add(19);
        set1.add(20);
        set1.add(21);
        return set1;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> itr = set.iterator();
        int x;
        while (itr.hasNext()) {
            x = itr.next();
            if (x > 10) {
                itr.remove();
            }
        }
return set;
    }
}
