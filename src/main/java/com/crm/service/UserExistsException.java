package com.crm.service;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class UserExistsException extends Exception
{
    public UserExistsException(String message)
    {
        super(message);
    }
}
