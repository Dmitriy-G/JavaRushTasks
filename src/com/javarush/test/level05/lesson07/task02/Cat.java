package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name2,add2, col2;
    String i1,i2,i3,i4;

    public void initialize(String name)
    {
        this.name2=name;
    }

    public void initialize(String name, String m, int v)
    {
        this.i1=name+m+v;
    }

    public void initialize(String name, int m, int v)
    {
        m=20;
        this.i2=name+m+v;
    }

    public void initialize(String name, String m, int v, String col, String add)
    {
        name=null;
        add=null;
        v=8;
        this.i3=name+m+v+col+add;
    }

    public void initialize(String m,String col, String add)
    {
        add="2323 nn";
        this.i3=m+col+add;
    }








}
