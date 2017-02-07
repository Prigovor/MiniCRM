package DAO;

import entity.Employee;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public interface EmployeeDAO {

    Long createEmployee(Employee contact);

    Employee readEmployee(Long id);

    void updateEmployee(Employee contact);

    void deleteEmployee(Long id );

    List<Employee> findAll();
}
