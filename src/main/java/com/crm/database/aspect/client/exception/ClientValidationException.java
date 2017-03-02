package com.crm.database.aspect.client.exception;

import com.crm.database.aspect.ServiceException;

/**
 * Created by Bohdan on 01.03.2017.
 */
public class ClientValidationException extends ServiceException
{
    public ClientValidationException()
    {
    }

    public ClientValidationException(String message)
    {
        super(message);
    }
}
