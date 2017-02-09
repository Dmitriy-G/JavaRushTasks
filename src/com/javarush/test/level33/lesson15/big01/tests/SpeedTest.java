package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Dima on 18.06.2016.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        Long t1 = new Date().getTime();
        for (String s:strings){
            ids.add(shortener.getId(s));
        }
        Long t2 = new Date().getTime();
        return t2-t1;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        Long t1 = new Date().getTime();
        for (Long id:ids){
            strings.add(shortener.getString(id));
        }
        Long t2 = new Date().getTime();
        return t2-t1;
    }

    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new TreeSet<>();
        Set<Long>ids=new TreeSet<>();
        for (int i = 0; i < 10000; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }

        long time1=getTimeForGettingIds(shortener1,origStrings,ids);
        long time2=getTimeForGettingIds(shortener2,origStrings,ids);
        Assert.assertTrue(time1>time2);

        long time3=getTimeForGettingStrings(shortener1, ids, origStrings);
        long time4=getTimeForGettingStrings(shortener2,ids,origStrings);

        Assert.assertEquals(time3,time4,5);
    }
}
