package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by Dima on 24.01.2016.
 */
public class Shortener
{
    private Long lastId=0L;
    private StorageStrategy storageStrategy;


    public Shortener(StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){
        Long id;
        if (storageStrategy.containsValue(string)) {
            id = storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
            id = lastId;
        }
        return id;
    }
    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }
}
