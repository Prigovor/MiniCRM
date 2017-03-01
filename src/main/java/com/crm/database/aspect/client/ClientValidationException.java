package com.crm.database.aspect.client;

/**
 * Created by Bohdan on 01.03.2017.
 */
public class ClientValidationException extends RuntimeException
{
    public ClientValidationException()
    {
    }

    public ClientValidationException(String message)
    {
        super(message);
    }
}
