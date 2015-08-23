package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String line = "";
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in); BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()))) {
            while ((line = reader.readLine()) != null) {
                list.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //...
        StringBuilder result = getLine();
        System.out.println(result.toString());
    }


    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(""))
            return new StringBuilder(words[0]);


          return null;
    }
}
