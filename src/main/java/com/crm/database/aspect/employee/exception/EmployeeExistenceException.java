package com.crm.database.aspect.employee.exception;

import com.crm.database.aspect.ServiceException;

/**
 * Created by Bohdan on 02.03.2017.
 */
public class EmployeeExistenceException extends ServiceException
{
    public EmployeeExistenceException()
    {
    }

    public EmployeeExistenceException(String message)
    {
        super(message);
    }
}
