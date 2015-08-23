package com.javarush.test.level08.lesson06.task05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Четыре метода
Реализовать 4 метода. Они должны возвращать список, который лучше всего подходит для выполнения данных операций (быстрее всего справится с большим количеством операций). Ничего измерять не нужно.
*/

public class Solution
{
    public static List  getListForGet(){
       ArrayList<String> arr1 =new ArrayList();
return arr1;
    }

    public static List  getListForSet()
    {
        ArrayList<String> arr1 =new ArrayList();
        return arr1;

    }

    public static List  getListForAddOrInsert()
    {
      LinkedList<String> arr2=new LinkedList<String>();
return arr2;
    }

    public static List  getListForRemove()
    {
        LinkedList<String> arr2=new LinkedList<String>();
        return arr2;
    }
}
