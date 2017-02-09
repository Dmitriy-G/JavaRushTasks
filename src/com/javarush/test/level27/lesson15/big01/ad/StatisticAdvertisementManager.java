package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 24.06.2016.
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager()
    {
    }

    public static StatisticAdvertisementManager getInstance()
    {
        return instance;
    }

    public List<Advertisement> getActiveVideo()
    {
        ArrayList<Advertisement> result = new ArrayList<>();
        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() > 0)
            {
                result.add(ad);
            }
        }
        return result;
    }

    public List<Advertisement> getNotActiveVideo()
    {
        ArrayList<Advertisement> result = new ArrayList<>();
        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() == 0)
            {
                result.add(ad);
            }
        }
        return result;
    }
}
