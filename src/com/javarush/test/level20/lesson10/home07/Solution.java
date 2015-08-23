package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private static final long serialVersionUID = 1L;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution("F:\\test.txt");
        solution.writeObject("Hi");
        solution.close();

        //SAVE
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\test2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();
        //LOAD
        FileInputStream fileInputStream = new FileInputStream("F:\\test2.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution t2 = (Solution) inputStream.readObject();
        inputStream.close();
        t2.writeObject("Hi2");
    }
}
