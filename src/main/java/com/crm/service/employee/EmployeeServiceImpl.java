package com.crm.service.employee;

import com.crm.dao.GenericDao;
import com.crm.entity.employee.Employee;
import com.crm.service.GenericServiceImpl;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Long>
{
    public EmployeeServiceImpl(GenericDao<Employee, Long> dao)
    {
        super(dao);
    }
}
