package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Dima on 23.01.2016.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        String[] s=f.getName().split("\\.");
        if (f.isDirectory()){
            return true;
        }
        switch (s[s.length-1]){
            case "html": return true;
            case "htm": return true;
            case "HTML": return true;
            case "HTM": return true;
            default: return false;
        }
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
