package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Dima on 22.06.2015.
 */
public class Hippodrome
{
    public ArrayList<Horse>horses=new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static Hippodrome game;
    public static void main(String[] args) throws InterruptedException
    {
        Hippodrome hip=new Hippodrome();
        game=hip;
        Horse hors1=new Horse("hors1",3,0);
        Horse hors2=new Horse("hors2",3,0);
        Horse hors3=new Horse("hors3",3,0);
        game.getHorses().add(hors1);
        game.getHorses().add(hors2);
        game.getHorses().add(hors3);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException
    {
        for (int i=0; i<100; i++){
            move();
            print();
            Thread.sleep(5);
        }

    }
    public void move(){
        for (int i=0; i<horses.size(); i++){
            horses.get(i).move();
        }

    }
    public void print(){
        for (int i=0; i<horses.size(); i++){
            horses.get(i).print();
        }
        System.out.println("");
        System.out.println("");
    }
    public Horse getWinner(){
       Horse winner=new Horse(null,0,0);
        for (int i=0; i<horses.size(); i++){
            if (winner.getDistance()<horses.get(i).getDistance()){
                winner=horses.get(i);
            }
        }
        return  winner;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
