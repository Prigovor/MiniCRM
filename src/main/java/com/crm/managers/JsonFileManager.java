package com.crm.managers;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Created by Bohdan on 10.02.2017.
 */
public class JsonFileManager
{
    private static Gson gson = new Gson();

    public static void serializeToJsonFile(Object object, String path) throws IOException
    {
        try (FileWriter fileWriter = new FileWriter(path))
        {
            fileWriter.write(gson.toJson(object));
        }
    }

    public static <T> T deserializeFromJsonFile(Class<T> tClass, String path) throws IOException
    {
        try (FileReader fileReader = new FileReader(path))
        {
            CharBuffer charBuffer = CharBuffer.allocate(16000);

            fileReader.read(charBuffer);

            return gson.fromJson(new String(charBuffer.array()).trim(), tClass);
        }
    }
}
