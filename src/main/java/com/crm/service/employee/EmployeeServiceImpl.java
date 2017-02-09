package com.crm.service.employee;

import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.entity.employee.Employee;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Long createEmployee(Employee employee)
    {
        Long id = employeeDAO.createEmployee(employee);

        return id;
    }

    @Override
    public Employee readEmployee(Long id)
    {
        Employee employee = employeeDAO.readEmployee(id);

        return employee;
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
        List<Employee> listEmployees = employeeDAO.findAll();

        return listEmployees;
    }
}
