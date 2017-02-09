package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Dima on 20.06.2016.
 */
public class StatisticEventManager
{
    private StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticEventManager instance = new StatisticEventManager();
    private Set<Cook> cookSet = new HashSet<>();

    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> map = new HashMap<>();

        private StatisticStorage()
        {
            for (EventType type : EventType.values())
            {
                map.put(type, new ArrayList<EventDataRow>());
            }
        }

        private List<EventDataRow> getData(EventType eventType)
        {
            return map.get(eventType);
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }
    }

    public static StatisticEventManager getInstance()
    {
        return instance;
    }

    public void register(Cook cook)
    {
        cookSet.add(cook);
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }


    public Map<Date, Double> getAdvertisingData()
    {
        TreeMap<Date, Double> result = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow data : statisticStorage.getData(EventType.SELECTED_VIDEOS))
        {
            Date date = getDateIgnoreTime(data.getDate());
            VideoSelectedEventDataRow temp = (VideoSelectedEventDataRow) data;
            if (result.containsKey(date))
            {
                result.put(date, result.get(date) + (0.01d * (double) temp.getAmount()));
            } else
            {
                result.put(date, (0.01d * (double) temp.getAmount()));
            }
        }

        return result;
    }


    public Map<Date, Map<String, Integer>> getCookData()
    {
        TreeMap<Date, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow row : statisticStorage.getData(EventType.COOKED_ORDER))
        {
            Date date = getDateIgnoreTime(row.getDate());
            CookedOrderEventDataRow temp = (CookedOrderEventDataRow) row;
            int time = temp.getTime();
            if (time % 60 == 0) time = time / 60;
            else time = time / 60 + 1;
            if (result.containsKey(date))
            {
                Map<String, Integer> map=result.get(date);
                if (map.containsKey(temp.getCookName())){
                    map.put(temp.getCookName(), map.get(temp.getCookName())+time);
                }else {
                    map.put(temp.getCookName(), time);
                }
            } else
            {
                Map<String, Integer> map = new HashMap<>();
                map.put(temp.getCookName(), time);
                result.put(date, map);
            }

        }
        return result;
    }

    private Date getDateIgnoreTime(Date date)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
