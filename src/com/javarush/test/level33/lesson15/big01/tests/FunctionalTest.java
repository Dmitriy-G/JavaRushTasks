package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dima on 18.06.2016.
 */
public class FunctionalTest
{
    public void testStorage(Shortener shortener){
        String s1="text1";
        String s2="text2";
        String s3="text1";
        long id1=shortener.getId(s1);
        long id2=shortener.getId(s2);
        long id3=shortener.getId(s3);
        Assert.assertNotEquals(id1,id2);
        Assert.assertNotEquals(id3, id2);
        Assert.assertEquals(id1, id3);
        String result1=shortener.getString(id1);
        String result2=shortener.getString(id2);
        String result3=shortener.getString(id3);
        Assert.assertEquals(s1, result1);
        Assert.assertEquals(s2, result2);
        Assert.assertEquals(s3, result3);
    }
    @Test
   public void testHashMapStorageStrategy(){

       testStorage(new Shortener(new HashMapStorageStrategy()));
    }

    @Test
   public void testOurHashMapStorageStrategy(){
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }

    @Test
   public void testFileStorageStrategy(){
        testStorage(new Shortener(new FileStorageStrategy()));
    }

    @Test
   public void testHashBiMapStorageStrategy(){
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }

    @Test
   public void testDualHashBidiMapStorageStrategy(){
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }

    @Test
   public void testOurHashBiMapStorageStrategy(){
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }
}
