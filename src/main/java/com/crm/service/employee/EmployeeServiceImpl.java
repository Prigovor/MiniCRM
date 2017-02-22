package com.crm.service.employee;

import com.crm.dao.FactoryDAO;
import com.crm.dao.employee.EmployeeDAO;
import com.crm.entity.employee.Employee;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO = FactoryDAO.getEmployeeDAO();

    @Override
    public Long createEmployee(Employee employee)
    {
        return employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee readEmployee(Long id)
    {
        return employeeDAO.readEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee)
    {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id)
    {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }
}
