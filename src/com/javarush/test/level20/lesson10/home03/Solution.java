package com.javarush.test.level20.lesson10.home03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution {

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A(){

        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream s) throws IOException,
                ClassNotFoundException {
           name=(String)s.readObject();
        }

        private void writeObject(ObjectOutputStream s) throws IOException
        {
            s.writeObject(name);
        }
    }
}
