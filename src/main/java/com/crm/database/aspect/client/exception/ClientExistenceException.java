package com.crm.database.aspect.client.exception;

import com.crm.database.aspect.ServiceException;

/**
 * Created by Bohdan on 02.03.2017.
 */
public class ClientExistenceException extends ServiceException
{
    public ClientExistenceException()
    {
    }

    public ClientExistenceException(String message)
    {
        super(message);
    }
}
