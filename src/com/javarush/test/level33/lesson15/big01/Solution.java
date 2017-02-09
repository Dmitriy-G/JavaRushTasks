package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dima on 24.01.2016.
 */
public class Solution
{
   public static Set<Long> getIds(Shortener shortener, Set<String> strings){
       Set<Long>result=new HashSet<>();
       for (String s:strings){
           result.add(shortener.getId(s));
       }
       return result;
   }
  public static  Set<String> getStrings(Shortener shortener, Set<Long> keys){
      Set<String>result=new HashSet<>();
      for (Long k:keys){
          result.add(shortener.getString(k));
      }
      return result;
  }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String>test=new HashSet<>();
        for (int i=0; i<elementsNumber; i++){
            test.add(Helper.generateRandomString());
        }
        Shortener shortener=new Shortener(strategy);
        Long t1 = new Date().getTime();
        Set<Long> keySet = getIds(shortener, test);
        Long t2 = new Date().getTime();

        Long duration1 = t2 - t1;
        Helper.printMessage(duration1.toString());
        Long t3 = new Date().getTime();
        Set<String> resSet = getStrings(shortener, keySet);
        Long t4 = new Date().getTime();
        Long duration2 = t4 - t3;
        Helper.printMessage(duration2.toString());
        if (resSet.equals(test)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args)
    {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new FileStorageStrategy(),100);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
    }
}
