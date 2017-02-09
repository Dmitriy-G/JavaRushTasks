package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> result = detectAllWords(crossword, "home", "same", "pga");
        for (Word word : result)
        {
            System.out.println(word.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        ArrayList<Word> result = new ArrayList<>();
        int cX = 0, cY = 0;
        boolean stop;
        for (String word : words)
        {
            stop = false;
            Word tempObj = new Word(word);
            char[] temps = word.toCharArray();


            //run start search
            for (int i = 0; i <= 4; i++)
            {
                if (stop)
                {
                    break;
                }
                for (int j = 0; j <= 5; j++)
                {
                    char ch = (char) crossword[i][j];
                    if (ch == temps[0])
                    {
                        tempObj.setStartPoint(j, i);
                        cX = i;
                        cY = j;
                        stop = true;
                        break;
                    }
                }
            }

            //stop start search, and run end search
            runEndSearch(crossword, temps, cX, cY, tempObj);
            result.add(tempObj);
        }
        return result;
    }

    public static void runEndSearch(int crossword[][], char[] temps, int startX, int startY, Word tempObj)
    {
        for (int k = 1; k < temps.length; )
        {
            if (startX - 1 >= 0 && startY - 1 >= 0)
            {
                char ch0 = (char) crossword[startX - 1][startY - 1];
                if (ch0 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY - temps.length + 1, startX - temps.length + 1);
                    }
                    break;
                }
            }

            if (startY - 1 >= 0)
            {
                char ch1 = (char) crossword[startX][startY - 1];
                if (ch1 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY - temps.length + 1, startX);
                    }
                    break;
                }
            }


            if (startX + 1 <= temps.length && startY - 1 >= 0)
            {
                char ch2 = (char) crossword[startX + 1][startY - 1];
                if (ch2 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY - temps.length + 1, startX + temps.length - 1);
                    }
                    break;
                }
            }


            if (startX + 1 <= temps.length)
            {
                char ch3 = (char) crossword[startX + 1][startY];
                if (ch3 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY, startX + temps.length - 1);
                    }
                    break;
                }
            }

            if (startX + 1 <= temps.length && startY + 1 <= temps.length)
            {
                char ch4 = (char) crossword[startX + 1][startY + 1];
                if (ch4 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY + temps.length - 1, startX + temps.length - 1);
                    }
                    break;
                }
            }

            if (startY - 1 <= temps.length)
            {
                char ch5 = (char) crossword[startX][startY + 1];
                if (ch5 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY + temps.length - 1, startX);
                    }
                    break;
                }
            }

            if (startX + 1 <= temps.length && startY - 1 >= 0)
            {
                char ch6 = (char) crossword[startX + 1][startY - 1];
                if (ch6 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY + temps.length - 1, startX - temps.length + 1);
                    }
                    break;
                }
            }

            if (startX - 1 >= 0)
            {
                char ch7 = (char) crossword[startX - 1][startY];
                if (ch7 == temps[k])
                {
                    for (int i = 2; i < temps.length; i++)
                    {
                        tempObj.setEndPoint(startY, startX - temps.length + 1);
                    }
                    break;
                }
            }

        }
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
