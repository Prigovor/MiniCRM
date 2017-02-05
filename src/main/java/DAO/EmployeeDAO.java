package DAO;

import entity.Employee;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public interface EmployeeDAO {

<<<<<<< HEAD
    Long createEmployee(Employee employee);

    Employee readEmployee(Long id);

    void updateEmployee(Employee employee);
=======
    Long createEmployee(Employee contact);

    Employee readEmployee(Long id);

    void updateEmployee(Employee contact);
>>>>>>> DAO

    void deleteEmployee(Long id );

    List<Employee> findAll();
}
