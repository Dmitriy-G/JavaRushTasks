package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by Dima on 17.06.2016.
 */
public class FileStorageStrategy implements StorageStrategy
{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    long bucketSizeLimit = 10000;
    int size;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    @Override
    public boolean containsKey(Long key)
    {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value)
    {
        if (value == null)
            return false;

        FileBucket[] tab = table;
        for (FileBucket aTab : tab)
            if (aTab != null)
            {
                for (Entry e = aTab.getEntry(); e != null; e = e.next)
                    if (value.equals(e.value))
                        return true;
            }
        return false;
    }

    @Override
    public void put(Long key, String value)
    {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index);
        }
        else {
            createEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value)
    {
        if (value == null)
            return 0L;
        for (FileBucket fileBucket : table)
        if (fileBucket.getEntry()!=null)
        {
            if (value.equals(fileBucket.getEntry().value))
                return fileBucket.getEntry().getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key)
    {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }

    int hash(Long k)
    {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    int indexFor(int hash, int length)
    {
        return hash & (length - 1);
    }

    Entry getEntry(Long key)
    {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());

        if (table[indexFor(hash, table.length)]==null){
            return null;
        }

        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next)
        {
            Entry entry = table[indexFor(hash, table.length)].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    void resize(int newCapacity)
    {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable)
    {
        for (int j = 0; j < table.length; j++)
        {
            if (table[j]!=null)
            {
                Entry e = table[j].getEntry();
                if (e != null)
                {
                    table[j] = null;
                    do
                    {
                        Entry next = e.next;
                        int i = indexFor(e.hash, newTable.length);
                        if (newTable[i]==null){
                            e.next = null;
                            newTable[i] = new FileBucket();
                        }
                        e.next = newTable[i].getEntry();
                        newTable[i].putEntry(e);
                        e = next;
                    }
                    while (e != null);
                }
                if (table[j]!=null)
                    table[j].remove();
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex)
    {
        if (table[bucketIndex]!=null)
        {
            Entry e = table[bucketIndex].getEntry();
            table[bucketIndex].putEntry(new Entry(hash, key, value, e));
            size++;
            if (bucketSizeLimit < table[bucketIndex].getFileSize())
                resize(2 * table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex)
    {
        table[bucketIndex]=new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    public void setBucketSizeLimit(long bucketSizeLimit)
    {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public long getBucketSizeLimit()
    {
        return bucketSizeLimit;
    }
}
