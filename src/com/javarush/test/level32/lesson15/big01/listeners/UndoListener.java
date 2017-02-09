package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by Dima on 22.01.2016.
 */
public class UndoListener implements UndoableEditListener
{
    private UndoManager undoManager;
    @Override
    public void undoableEditHappened(UndoableEditEvent e)
    {
        undoManager.addEdit(e.getEdit());
    }

    public UndoListener(UndoManager undoManager)
    {
        this.undoManager = undoManager;
    }
}
