package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Dima on 25.01.2016.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    {
        try
        {
            path = Files.createTempFile("tmp",null);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){

        return path.toFile().length();
    }

    public void putEntry(Entry entry){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
            outputStream.writeObject(entry);
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry(){
        Entry entry = null;
        if(getFileSize() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()))){
                Object object = inputStream.readObject();
                entry = (Entry)object;
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
        return entry;
    }

    public void remove(){
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }

}
