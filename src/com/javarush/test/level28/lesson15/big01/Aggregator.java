package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Dima on 20.01.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        //Strategy hhStrategy=new HHStrategy();
        Strategy moikrugStrategy=new MoikrugStrategy();
        Provider[]providers={new Provider(moikrugStrategy)};
        HtmlView view=new HtmlView();
        Model model=new Model(view,providers);
        Controller controller=new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
