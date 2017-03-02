package com.crm.database.aspect;

/**
 * Created by Bohdan on 02.03.2017.
 */
public class ServiceException extends RuntimeException
{
    public ServiceException()
    {
    }

    public ServiceException(String message)
    {
        super(message);
    }
}
