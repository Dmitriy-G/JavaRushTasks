package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }



    public static void printMatrix(int m, int n, char z, Object value) {
    }
    public static void printMatrix(int m, int n, String z, Object value) {
    }

    public static void printMatrix(int m, int n, byte z, Object value) {
    }

    public static void printMatrix(int m, String n, char z, Object value) {

    }
    public static void printMatrix(String m, String n, char z, Object value) {

    }
    public static void printMatrix(byte m, String n, char z, Object value) {

    }
    public static void printMatrix(int m, byte n, char z, Object value) {

    }
    public static void printMatrix(int m, String n, byte z, Object value) {

    }
}
