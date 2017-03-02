package com.crm.database.aspect.account.exception;

import com.crm.database.aspect.ServiceException;

/**
 * Created by Bohdan on 01.03.2017.
 */
public class AccountValidationException extends ServiceException
{
    public AccountValidationException()
    {
    }

    public AccountValidationException(String message)
    {
        super(message);
    }
}
