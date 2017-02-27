package com.crm.service.employee;

import com.crm.dao.FactoryDao;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class EmployeeServiceImplHibernate extends EmployeeServiceImpl
{
    public EmployeeServiceImplHibernate()
    {
        super(FactoryDao.getEmployeeDao());
    }
}
