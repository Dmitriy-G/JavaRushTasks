package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread s1=new SpecialThread();
        Thread t1=new Thread(s1);
        list.add(t1);
        SpecialThread s2=new SpecialThread();
        Thread t2=new Thread(s1);
        list.add(t2);
        SpecialThread s3=new SpecialThread();
        Thread t3=new Thread(s1);
        list.add(t3);
        SpecialThread s4=new SpecialThread();
        Thread t4=new Thread(s1);
        list.add(t4);
        SpecialThread s5=new SpecialThread();
        Thread t5=new Thread(s1);
        list.add(t5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
