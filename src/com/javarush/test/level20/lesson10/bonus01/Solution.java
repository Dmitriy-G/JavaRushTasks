package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

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
public class Solution {

    public static void main(String[] args)
    {
        int[]arr=getNumbers(100000000);
        for(int element:arr){
            System.out.println(element);
        }
    }

    public static int[] getNumbers(int N) {
        int[] result;
        ArrayList<Integer>list=new ArrayList<>();
        int i=1;
        while (i<=N){
            String s=i+"";
            char[]chars=s.toCharArray();
            int res=0;
            for (char temp : chars)
            {
                int sq=1;
                for (char ignore : chars)
                {
                   sq=sq*(temp-48);
                }
                res=res+sq;
            }
            if (i-res==0){
                list.add(i);
            }
            i++;
        }
        result=new int[list.size()];
        for(int j=0; j<result.length; j++){
            result[j]=list.get(j);
        }
        return result;
    }
}
