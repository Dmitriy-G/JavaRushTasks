package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ConsoleStream=System.out;
        ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result=outputStream.toString();
        System.setOut(ConsoleStream);
        StringTokenizer st=new StringTokenizer(result);
        int A = Integer.parseInt(st.nextToken());
        String znak=st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int C=0;
        if (znak.equals("+")){
            C=A+B;
        }
        if (znak.equals("-")){
             C=A-B;
        }
        if (znak.equals("*")){
            C=A*B;
        }

        System.out.print(result+C);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

