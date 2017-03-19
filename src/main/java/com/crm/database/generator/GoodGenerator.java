package com.crm.database.generator;

import com.crm.database.entity.good.Good;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Bohdan on 19.03.2017.
 */
public class GoodGenerator
{
    private static final GoodGenerator instance = new GoodGenerator();

    public static GoodGenerator getInstance()
    {
        return instance;
    }

    private GoodGenerator()
    {

    }

    public Good generateGood()
    {
        Good good = new Good();

        good.setName(generateName());
        good.setDescription(generateDescription());
        good.setAmount(generateAmount());
        good.setPrice(generatePrice());

        return good;
    }

    private List<String> listNames =
            Arrays.asList("ACER ASPIRE", "DELL INSPIRON", "LENOVO IDEAPAD", "ASUS ROG");

    private Random random = new Random();

    private String generateName()
    {
        int randomNameIndex = random.nextInt(listNames.size());
        int randomNumber = (random.nextInt(16) + 1) * 100;

        return listNames.get(randomNameIndex) + "-" + randomNumber;
    }

    private String generateDescription()
    {
        Faker faker = new Faker();
        return faker.lorem().paragraph();
    }

    private Integer generateAmount()
    {
        return random.nextInt(20) + 1;
    }

    private Double generatePrice()
    {
        return random.nextInt(16) * 10000d;
    }
}
