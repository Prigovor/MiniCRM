package com.crm.database.aspect.account;

/**
 * Created by Bohdan on 01.03.2017.
 */
public class AccountValidationException extends RuntimeException
{
    public AccountValidationException()
    {
    }

    public AccountValidationException(String message)
    {
        super(message);
    }
}
