package com.crm.database.validation;

/**
 * Created by Bohdan on 05.03.2017.
 */
public class ValidationException extends RuntimeException
{
    public ValidationException()
    {
    }

    public ValidationException(String message)
    {
        super(message);
    }
}
