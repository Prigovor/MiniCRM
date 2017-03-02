package com.crm.database.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Bohdan on 28.02.2017.
 */
public class ContextManager
{
    private static final ContextManager contextManager = new ContextManager();

    public static ContextManager getInstance()
    {
        return contextManager;
    }

    private ContextManager()
    {

    }

    private final ApplicationContext context = new GenericXmlApplicationContext("spring-config/spring-config.xml");

    public ApplicationContext getContext()
    {
        return context;
    }
}
