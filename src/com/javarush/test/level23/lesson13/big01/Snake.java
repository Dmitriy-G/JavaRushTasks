package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by Dima on 30.06.2015.
 */
public class Snake
{
    private ArrayList<SnakeSection>sections;
    private boolean isAlive;
    private SnakeDirection direction;


    public Snake(int x, int y)
    {
        sections = new ArrayList<SnakeSection>();
        SnakeSection snakeSectionFirst = new SnakeSection(x,y);
        sections.add(snakeSectionFirst);
        this.isAlive =true;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public int getX()
    {
        return sections.get(0).getX();
    }

    public int getY()
    {
        return sections.get(0).getY();
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }


    public void move()
    {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }

    public void move(int dx, int dy)
    {
        //Создаем новую голову - новый "кусочек змеи".
        SnakeSection head =sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);
        //Проверяем - не вылезла ли голова за границу комнаты
        checkBorders(head);
        if (!isAlive) return;
        //Проверяем - не пересекает ли змея  саму себя
        checkBody(head);
        if (!isAlive) return;
        //Проверяем - не съела ли змея мышь.
        Mouse mouse = Room.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) //съела
        {
            sections.add(0, head);                  //Добавили новую голову
            Room.game.eatMouse();                   //Хвот не удаляем, но создаем новую мышь.
        }
        else //просто движется
        {
            sections.add(0, head);                  //добавили новую голову
            sections.remove(sections.size() - 1);   //удалили последний элемент с хвоста
        }
    }

    /**
     *  Метод проверяет - находится ли новая голова в пределах комнаты
     */
    private void checkBorders(SnakeSection head)
    {
        if ((head.getX() < 0 || head.getX() >= Room.game.getWidth()) || head.getY() < 0 || head.getY() >= Room.game.getHeight())
        {
            isAlive = false;
        }
    }

    /**
     *  Метод проверяет - не совпадает ли голова с каким-нибудь участком тела змеи.
     */
    private void checkBody(SnakeSection head)
    {
        if(sections.contains(head))
            isAlive = false;
    }

}
