package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream object;

    AdapterFileOutputStream(FileOutputStream object){
        this.object=object;
    }

    @Override
    public void flush() throws IOException
    {
        this.object.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        byte[] iArr = new byte[s.length()];
        iArr=s.getBytes();
        this.object.write(iArr);
    }

    @Override
    public void close() throws IOException
    {
       this.object.close();
    }
}

