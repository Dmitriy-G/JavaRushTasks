package com.javarush.test.level23.lesson13.big01;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Dima on 30.06.2015.
 */
public class Room
{
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width,int height, Snake snake)
    {
        this.width = width;
        this.height=height;
        this.snake=snake;
    }

    public int getWidth()
    {
        return width;
    }

    public Snake getSnake()
    {
        return snake;
    }

    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }

    public int getHeight()
    {
        return height;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }
    public void run()
    {
//������� ������ "����������� �� �����������" � �������� ���.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //���� ���� ����
        while (snake.isAlive())
        {
            //"�����������" �������� ������� � ������� ������?
            if (keyboardObserver.hasKeyEvents())
            {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //���� ����� ������� 'q' - ����� �� ����.
                if (event.getKeyChar() == 'q') return;

                //���� "������� �����" - �������� ������� �����
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //���� "������� ������" - �������� ������� ������
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //���� "������� �����" - �������� ������� �����
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //���� "������� ����" - �������� ������� ����
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move(0, 2);   //������� ����
            print();        //���������� ������� ��������� ����
            sleep();        //����� ����� ������
        }

        //������� ��������� "Game Over"
        System.out.println("Game Over!");
    }
    public void print()
    {
        //������� ������, ���� ����� "��������" ������� ��������� ����
        int[][] matrix = new int[width][height];
        //������ ��� ������� ����
        int snakeLen = snake.getSections().size();
        for (int i = 0; i < snakeLen; i++)
        {
            int y = snake.getSections().get(i).getY();
            int x = snake.getSections().get(i).getX();
            if (i == 0)
            {
                matrix[y][x] = 2;
            } else
            {
                matrix[y][x] = 1;
            }
        }

        //������ ����
        matrix[mouse.getY()][mouse.getX()] = 3;
        //������� ��� ��� �� �����
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
                if (matrix[x][y] == 0) {
                    System.out.print('.');
                } else if (matrix[x][y] == 1) {
                    System.out.print('x');
                } else if (matrix[x][y] == 2) {
                    System.out.print('X');
                }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public void sleep()
    {
        Snake snake=getSnake();
        ArrayList<SnakeSection> sections=snake.getSections();
        try {
            int timeSleep;
            timeSleep = (int)( 500 - (1.0f * 200 / 9)*(sections.size() - 1));
            Thread.sleep(timeSleep > 200 ? timeSleep : 200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


    public void eatMouse(){
       this.createMouse();
    }

    public void createMouse()
    {
        int x = (int) (Math.random() * this.width);
        int y = (int) (Math.random() * this.height);

        this.mouse = new Mouse(x,y);
    }

    public static Room game;

    public static void main(String[] args)
    {
        game = new Room(20, 20, new Snake (10,10));
        game.getSnake().setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }
}
