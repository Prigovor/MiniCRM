package DAO;

import entity.Employee;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public interface EmployeeDAO {

    Long createEmployee(Employee employee);
<<<<<<< HEAD
    Long createEmployee(Employee employee);

    Employee readEmployee(Long id);

    void updateEmployee(Employee employee);
=======
    Long createEmployee(Employee contact);

    Employee readEmployee(Long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id );

    List<Employee> findAll();
}
