package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> addresses = new ArrayList<String>();
        while (true)
        {
            String City = reader.readLine();
            if (City.isEmpty()) break;
            addresses.add(City);

            String family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.add(family);

        }

        //read home number
        String poisk = reader.readLine();

        for (int i=0; i<addresses.size(); i++){
            String p=addresses.get(i);
            int j=i+1;
           if (p.contains(poisk)){
               System.out.println(addresses.get(j));
           }
        }

    }
}
