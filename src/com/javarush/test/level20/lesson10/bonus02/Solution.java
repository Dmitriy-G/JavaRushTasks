package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a)
    {
        right(a,0,0,0,0,0,0);
        return 0;
    }


    public static void right(byte[][] a, int x, int y,int countR, int countB, int countL, int countT)
    {
        if ((a[x][y]==0)||(y==3)){
            a[x][y]=2;
            countB++;
            bot(a, x+1, y-1, countR,countB,countL,countT);
        }
        if (a[x][y]==1){
            a[x][y]=2;
            countR++;
            right(a, x, y+1, countR,countB,countL,countT);
        }
    }

    public static void bot(byte[][] a, int x, int y, int countR, int countB, int countL, int countT)
    {
        if (a[x][y]==0||x==3){
            a[x][y]=2;
            countL++;
            left(a, x-1, y-1, countR,countB,countL,countT);
        }
        if (a[x][y]==1){
            a[x][y]=2;
            countB++;
            bot(a, x+1, y, countR,countB,countL,countT);
        }


    }

    public static void left(byte[][] a, int x, int y, int countR, int countB, int countL, int countT)
    {
        if (a[x][y]==0||y==0){
            a[x][y]=2;
            countT++;
            top(a, x-1, y+1, countR,countB,countL,countT);
        }
        if (a[x][y]==1){
            a[x][y]=2;
            countL++;
            left(a, x,y-1,countR,countB,countL,countT);
        }


    }

    public static void top(byte[][] a, int x, int y, int countR, int countB, int countL, int countT)
    {
        if (a[x][y]==0||x==0){
            a[x][y]=2;
            countR++;
            right(a, x+1,y+1, countR,countB,countL,countT);
        }
        if (a[x][y]==1){
            a[x][y]=2;
            countT++;
            top(a, x - 1, y, countR, countB, countL,countT);
        }
    }
}
