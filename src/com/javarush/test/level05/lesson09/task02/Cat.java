package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name, m,v,c,add;
    private Cat (String name)
    {
        this.name = name;
    }
    private Cat (String name, String m, String v)
    {
        this.name = name;
        this.m=m;
        this.v=v;
    }
    private Cat (String name, String v)
    {
        this.name = name;
        this.m="ssd";
        this.v=v;
    }
    private Cat (String m, String c, int i)
    {
        this.name = null;
        this.m=m;
        this.v="12";
        this.c=c;
        this.add=null;
    }
    private Cat (String m, String c, String add, int i)
    {
        this.name = null;
        this.m=m;
        this.v="12";
        this.c=c;
        this.add="sfefwef23";
    }
}


