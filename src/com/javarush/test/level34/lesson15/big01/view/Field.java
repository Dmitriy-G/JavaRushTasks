package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by Dima on 04.02.2016.
 */
public class Field extends JPanel
{
    private EventListener eventListener;
    private View view;

    public Field(View view)
    {
        this.view = view;
        KeyHandler handler=new KeyHandler(this);
        this.addKeyListener(handler);
        this.setFocusable(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getWidth());
        GameObjects objects = view.getGameObjects();
        Set<GameObject> objectSet = objects.getAll();
        for (GameObject object:objectSet){
            object.draw(g);
        }
    }

    public void setEventListener(EventListener eventListener){

    }

    public static class KeyHandler extends KeyAdapter{
        private Field field;

        public KeyHandler(Field field)
        {
            this.field = field;
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT: field.eventListener.move(Direction.LEFT); break;
                case KeyEvent.VK_RIGHT: field.eventListener.move(Direction.RIGHT); break;
                case KeyEvent.VK_UP: field.eventListener.move(Direction.UP); break;
                case KeyEvent.VK_DOWN: field.eventListener.move(Direction.DOWN); break;
                case KeyEvent.VK_R: field.eventListener.restart(); break;
            }
        }
    }
}
