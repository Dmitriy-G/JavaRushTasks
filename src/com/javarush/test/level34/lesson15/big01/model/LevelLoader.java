package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dima on 04.02.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){
        Player player=new Player(10,10);
        Set<Box>boxes=new HashSet<>();
        Set<Home>homes=new HashSet<>();
        Set<Wall>walls=new HashSet<>();

        boxes.add(new Box(20,20));
        homes.add(new Home(20,40));
        walls.add(new Wall(60,40));
        walls.add(new Wall(80,40));
        walls.add(new Wall(20,60));
        walls.add(new Wall(60,80));

        GameObjects objects=new GameObjects(walls,boxes,homes,player);
        return objects;
    }
}
