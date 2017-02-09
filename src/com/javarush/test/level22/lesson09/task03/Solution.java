package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        reader.close();

        BufferedReader fileReader=new BufferedReader(new FileReader(fileName));
        String s;
        String []arr=null;
        while (fileReader.ready()){
            s=fileReader.readLine();
            s=s.replaceAll("\uFEFF","");
            arr=s.split(" ");
        }
        fileReader.close();
        StringBuilder result = getLine(arr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder builder = new StringBuilder();
        if (words.length==0){
            return builder;
        }
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);

        while (list.size() > 0)
        {
            Collections.shuffle(list);
            for (int i=0; i<list.size(); i++){
                if (i<list.size()-1)
                {
                    String letter1= list.get(i).toLowerCase();
                    String letter2=list.get(i+1).toLowerCase();
                    if (letter1.charAt(letter1.length()-1)!=letter2.charAt(0))
                    {
                        break;
                    }
                }else {
                    for (int j=0; i<list.size(); j++){
                        if (j<list.size())
                        {
                            builder.append(list.get(j)).append(" ");
                        }else {
                            list.removeAll(list);
                        }
                    }
                }
            }
        }
        return builder;
    }
}
