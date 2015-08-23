package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Collections;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static int[] getNumbers(int N)
    {
        int[] test = new int[N - 1];
        ArrayList<Integer>tempList=new ArrayList<>();
        for (int i = 0; i < test.length; i++)
        {
            test[i] = i + 1;
        }

        for (int i = 0; i < test.length; i++)
        {
            int M = (int) Math.log10(test[i]) + 1;
            int[]temp=counter(test[i]);
            int tempSum=0;
            for (int j=0; j<temp.length; j++){
                tempSum=tempSum+(int)Math.pow(temp[j],M);
            }
            if (test[i] == tempSum)
            {
                tempList.add(0,test[i]);
            }
        }
        Collections.sort(tempList);
        int[] result = new int[tempList.size()];
        for (int i=0; i<tempList.size(); i++){
            result[i]=tempList.get(i);
        }
        return result;
    }

    public static int[] counter(int x)
    {
        ArrayList<Integer>list=new ArrayList<>();
        int digitCounter;
        for (int i = 0; i < 10; i++)
        {
            int tmp = x;
            digitCounter = 0;
            while (tmp != 0)
            {
                int ost = tmp % 10;
                tmp /= 10;
                if (ost == i)
                {
                    digitCounter++;
                }
            }
            for (int j=digitCounter; j!=0;j--)
            {
                list.add(0, i);
            }
        }
        int array[]=new int[list.size()];
        for (int i=0; i<list.size(); i++){
            array[i]=list.get(i);
        }
        return array;
    }

    public static void main(String[] args)
    {
        int[]result = getNumbers(10000000);

    }
}
