package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Dima on 03.02.2016.
 */
public class FactoryProducer
{
    public static enum HumanFactoryType{
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type){
        if (type==HumanFactoryType.MALE){
            return new MaleFactory();
        }else {
            return new FemaleFactory();
        }
    }
}
