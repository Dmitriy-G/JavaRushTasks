package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Dima on 21.01.2016.
 */
public class TabbedPaneChangeListener implements ChangeListener
{

    private View view;
    @Override
    public void stateChanged(ChangeEvent e)
    {
       view.selectedTabChanged();
    }

    public TabbedPaneChangeListener(View view)
    {
        this.view = view;
    }
}
