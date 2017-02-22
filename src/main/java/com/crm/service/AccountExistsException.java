package com.crm.service;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class AccountExistsException extends Exception
{
    public AccountExistsException(String message)
    {
        super(message);
    }
}
