package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Dima on 18.07.2015.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();


    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

    public boolean hasMoney()
    {
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return (getTotalAmount() >= expectedAmount);
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer>cloneMap=new HashMap<>();
        cloneMap.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : cloneMap.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = cloneMap.get(key);
            while (true) {
                if (expectedAmount < key || value <= 0) {
                    cloneMap.put(key, value);
                    break;
                }
                expectedAmount -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }
        if (expectedAmount != 0)
        {
            throw new NotEnoughMoneyException();
        }
        denominations.clear();
        denominations.putAll(cloneMap);
        return result;
    }
}
