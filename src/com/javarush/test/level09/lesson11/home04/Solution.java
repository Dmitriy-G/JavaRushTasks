package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        DateFormat now = new SimpleDateFormat("MM/dd/yyyy");
        Date dat=now.parse(reader.readLine());

        DateFormat now2 = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
        String dat2=now2.format(dat).toUpperCase();
        System.out.println(dat2);



    }
}
