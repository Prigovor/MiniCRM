package com.crm.database.manager;

import com.crm.database.manager.hibernate.HibernateDatabaseManager;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class FactoryDatabaseManager
{
    private static final HibernateDatabaseManager hibernateDatabaseManager =
            new GenericXmlApplicationContext("spring-config/spring-config.xml")
                    .getBean(HibernateDatabaseManager.class);

    public static DatabaseManager getDatabaseManager(DatabaseManagerType type)
    {
        switch (type)
        {
            case HIBERNATE:
            {
                return hibernateDatabaseManager;
            }
        }

        return hibernateDatabaseManager;
    }
}
