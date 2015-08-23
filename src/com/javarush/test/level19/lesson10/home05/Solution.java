package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file1 = args[0];
        String file2 = args[1];
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        FileWriter outFile = new FileWriter(file2);
        ArrayList<String>stroki=new ArrayList<>();
        String line;
        while ((line = reader1.readLine()) != null) {
            String[] words=line.split(" ");
            for (int i=0; i<words.length; i++){
                stroki.add(words[i]);
            }
        }
        for (int i=0; i<stroki.size(); i++){
            String p =stroki.get(i).replaceAll("[^\\d]","");
            if (p.length()>0){
                outFile.write(stroki.get(i));
                outFile.write(" ");
            }
        }
        reader.close();
        reader1.close();
        outFile.close();
    }
}
