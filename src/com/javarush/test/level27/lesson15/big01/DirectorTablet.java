package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Dima on 22.06.2016.
 */
public class DirectorTablet
{

    public void printAdvertisementProfit()
    {
        StatisticEventManager manager = StatisticEventManager.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        TreeMap<Date, Double> data = (TreeMap<Date, Double>) manager.getAdvertisingData();
        List<Map.Entry<Date, Double>> list = new ArrayList(data.entrySet());

        double totalAmount = 0;
        for (Map.Entry<Date, Double> entry : list)
        {
            totalAmount = totalAmount + entry.getValue();
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %.2f", format.format(entry.getKey()), entry.getValue()));
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"Total - %.2f", totalAmount));
    }

    public void printCookWorkloading()
    {
        StatisticEventManager manager = StatisticEventManager.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        Map<Date, Map<String, Integer>> data = manager.getCookData();
        List<Map.Entry<Date, Map<String, Integer>>> list = new ArrayList(data.entrySet());


        for (Map.Entry<Date, Map<String, Integer>> entry : list)
        {
            ConsoleHelper.writeMessage(format.format(entry.getKey()));
            List<Map.Entry<String, Integer>> cookEntries = new ArrayList(entry.getValue().entrySet());
            Collections.sort(cookEntries, new Comparator<Map.Entry<String, Integer>>()
            {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                {
                    return o1.getKey().compareToIgnoreCase(o2.getKey());
                }
            });
            for (Map.Entry<String, Integer> cookEntry:cookEntries){
                if (cookEntry.getValue()>0)
                {
                    ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %d min", cookEntry.getKey(), cookEntry.getValue()));
                }
            }
        }
    }

    public void printActiveVideoSet()
    {
        StatisticAdvertisementManager manager=StatisticAdvertisementManager.getInstance();
        ArrayList<Advertisement>ads= (ArrayList<Advertisement>) manager.getActiveVideo();
        Collections.sort(ads, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad:ads){
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %d", ad.getName(), ad.getHits()));
        }
    }

    public void printArchivedVideoSet()
    {
        StatisticAdvertisementManager manager=StatisticAdvertisementManager.getInstance();
        ArrayList<Advertisement>ads= (ArrayList<Advertisement>) manager.getNotActiveVideo();
        Collections.sort(ads, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad:ads){
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
