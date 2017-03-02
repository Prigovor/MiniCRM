package com.crm.database.aspect.account.exception;

import com.crm.database.aspect.ServiceException;

/**
 * Created by Bohdan on 02.03.2017.
 */
public class AccountExistenceException extends ServiceException
{
    public AccountExistenceException()
    {
    }

    public AccountExistenceException(String message)
    {
        super(message);
    }
}
