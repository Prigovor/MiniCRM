package com.crm.database.service.employee;

import com.crm.database.dao.GenericDao;
import com.crm.database.service.GenericServiceImpl;
import com.crm.database.entity.employee.Employee;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class EmployeeService extends GenericServiceImpl<Employee, Long>
{
    public EmployeeService(GenericDao<Employee, Long> dao)
    {
        super(dao);
    }
}
