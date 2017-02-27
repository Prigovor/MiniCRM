package com.crm.managers.database;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class DatabaseManagerFactory
{
    private static final HibernateDatabaseManager hibernateDatabaseManager =
            new GenericXmlApplicationContext("spring-config/spring-config.xml")
                    .getBean(HibernateDatabaseManager.class);

    public static HibernateDatabaseManager getHibernateDatabaseManager()
    {
        return hibernateDatabaseManager;
    }
}
