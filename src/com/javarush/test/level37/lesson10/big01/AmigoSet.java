package com.javarush.test.level37.lesson10.big01;

import java.io.*;
import java.util.*;

/**
 * Created by Dima on 07.02.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>
{

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet()
    {
        map = new HashMap<>();
    }

    public  AmigoSet(Collection<? extends E> collection)
    {
        map = new HashMap<>((int) Math.max(16, collection.size() / .75f));
        this.addAll(collection);
    }

    @Override
    public Object clone()
    {
        try
        {
            this.addAll(this);
            this.map.putAll(this.map);
        }
        catch (Exception e)
        {
            throw new InternalError();
        }
        return this;
    }

    @Override
    public Iterator iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e)
    {
        return null == map.put(e, PRESENT);
    }

    @Override
    public int size()
    {
        return map.size();
    }

    @Override
    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o)
    {
        if (this.contains(o))
        {
            map.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public void clear()
    {
        map.clear();
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException
    {
        outputStream.defaultWriteObject();
        outputStream.writeObject(map.size());
        for(E e:map.keySet()){
            outputStream.writeObject(e);
        }
        outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException
    {
        inputStream.defaultReadObject();
        int size = (int)inputStream.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)inputStream.readObject());
        }
        int capacity = (int)inputStream.readObject();
        float loadFactor = (float)inputStream.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }

}
