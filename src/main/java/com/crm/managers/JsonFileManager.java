package com.crm.managers;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Bohdan on 10.02.2017.
 */
public class JsonFileManager
{
    private static Gson gson = new Gson();

    public static void serializeToJsonFile(Object object, String path) throws IOException
    {
        Files.deleteIfExists(Paths.get(path));

        try (FileWriter fileWriter = new FileWriter(path))
        {
            fileWriter.write(gson.toJson(object));
        }
    }

    public static <T> T deserializeFromJsonFile(Class<T> tClass, String path) throws IOException
    {
        if (!path.endsWith(".json"))
        {
            throw new IOException("Wrong file type. Need .json file type");
        }

        try (FileReader fileReader = new FileReader(path))
        {
            CharBuffer charBuffer = CharBuffer.allocate(16000);

            fileReader.read(charBuffer);

            return gson.fromJson(new String(charBuffer.array()).trim(), tClass);
        }
    }
}
