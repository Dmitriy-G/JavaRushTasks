package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Dima on 22.01.2016.
 */
public class TextEditMenuListener implements MenuListener
{

    private View view;
    @Override
    public void menuSelected(MenuEvent e)
    {
        JMenu menu= (JMenu) e.getSource();
        for (Component component:menu.getMenuComponents()){
            component.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }

    public TextEditMenuListener(View view)
    {
        this.view = view;
    }
}
