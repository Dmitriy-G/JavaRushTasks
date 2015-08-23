package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null){
            throw new TooShortStringException();
        }
        if (string.isEmpty())
            throw new TooShortStringException();
        int firstTab=string.indexOf('\t');
        if (firstTab==-1){
        throw new TooShortStringException();
    }

        int twoTab=string.indexOf('\t', firstTab+1);
        if (twoTab==-1){
            throw new TooShortStringException();
        }
        String sub=string.substring(firstTab+1,twoTab);
        return sub;
    }

    public static class TooShortStringException extends Exception {
    }
}
