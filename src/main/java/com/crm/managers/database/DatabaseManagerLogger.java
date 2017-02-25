package com.crm.managers.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bohdan on 25.02.2017.
 */
public class DatabaseManagerLogger
{
    private static final Logger logger = LoggerFactory.getLogger(DatabaseManagerLogger.class);

    public void beforeSave()
    {
        logger.info("Save method run");
    }

    public void afterSave()
    {
        logger.info("Save method worked successfully");
    }

    public void afterThrowingSave()
    {
        logger.error("Error while running save method");
    }
}
