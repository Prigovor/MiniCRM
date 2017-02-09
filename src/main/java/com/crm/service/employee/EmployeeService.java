package com.crm.service.employee;

import com.crm.entity.employee.Employee;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface EmployeeService
{
    Long createEmployee(Employee employee);

    Employee readEmployee(Long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> findAll();
}
