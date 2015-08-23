package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Dima on 19.05.2015.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageType)
    {
        if (imageType == ImageTypes.BMP) return new BmpReader();
        else
        if (imageType == ImageTypes.JPG) return new JpgReader();
        else
        if (imageType == ImageTypes.PNG) return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
