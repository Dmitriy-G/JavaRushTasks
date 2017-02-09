package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dima on 21.01.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane=new JTabbedPane();
    private JTextPane htmlTextPane=new JTextPane();
    private JEditorPane plainTextPane=new JEditorPane();
    private UndoManager undoManager=new UndoManager();
    private UndoListener undoListener=new UndoListener(undoManager);
    @Override
    public void actionPerformed(ActionEvent e)
    {
       switch (e.getActionCommand()){
           case "Новый": controller.createNewDocument(); break;
           case "Открыть": controller.openDocument(); break;
           case "Сохранить": controller.saveDocument(); break;
           case "Сохранить как...": controller.saveDocumentAs(); break;
           case "Выход": controller.exit(); break;
           case "О программе": this.showAbout(); break;
       }
    }

    public void init(){
       initGui();
        FrameListener listener=new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public Controller getController()
    {
        return controller;
    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){
        JMenuBar menuBar=new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public  void initEditor()
    {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(1000, 500));
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged()
    {
        if (isHtmlTabSelected()){
            controller.setPlainText(plainTextPane.getText());
        }else {
            plainTextPane.setText(controller.getPlainText());
        }
        this.resetUndo();
    }

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
           ExceptionHandler.log(e);
        }

    }
    public boolean canUndo(){

        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void undo(){
        undoManager.undo();
    }

    public void redo(){
        undoManager.redo();
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }
    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
       htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this,"Info","test",JOptionPane.INFORMATION_MESSAGE);
    }
}
