package com.crm.dao.employee;

import com.crm.entity.employee.Employee;
import com.crm.managers.database.HibernateDatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public class EmployeeDAOImpl implements EmployeeDAO
{
    @Override
    public Long createEmployee(Employee employee)
    {
        return HibernateDatabaseManager.getInstance().saveEntry(employee);
    }

    @Override
    public Employee readEmployee(Long id)
    {
        return HibernateDatabaseManager.getInstance().getEntry(id, Employee.class);
    }

    @Override
    public void updateEmployee(Employee employee)
    {
        HibernateDatabaseManager.getInstance().updateEntry(employee);
    }

    @Override
    public void deleteEmployee(Long id)
    {
        HibernateDatabaseManager.getInstance().deleteEntry(id, Employee.class);
    }

    @Override
    public List<Employee> findAll()
    {
        return HibernateDatabaseManager.getInstance().getEntries(Employee.class);
    }
}
