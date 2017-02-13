package com.crm.service.employee;

import com.crm.entity.employee.Employee;
import com.crm.service.UserValidationException;
import com.crm.service.SecureService;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface EmployeeService extends SecureService {
    Long createEmployee(Employee employee) throws UserValidationException;

    Employee readEmployee(Long id) throws UserValidationException;

    void updateEmployee(Employee employee) throws UserValidationException;

    void deleteEmployee(Long id) throws UserValidationException;

    List<Employee> findAll() throws UserValidationException;
}