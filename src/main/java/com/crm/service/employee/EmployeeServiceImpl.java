package com.crm.service.employee;

import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.service.UserValidationException;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public Long createEmployee(Employee employee) throws UserValidationException {
        validateUser();

        return employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee readEmployee(Long id) throws UserValidationException {
        validateUser();

        return employeeDAO.readEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) throws UserValidationException {
        validateUser();

        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) throws UserValidationException {
        validateUser();

        employeeDAO.deleteEmployee(id);
    }

    @Override
    public List<Employee> findAll() throws UserValidationException {
        validateUser();

        return employeeDAO.findAll();
    }
}