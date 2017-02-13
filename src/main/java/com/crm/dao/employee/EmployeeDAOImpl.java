package com.crm.dao.employee;

import com.crm.entity.employee.Employee;
import com.crm.managers.DatabaseManager;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Long createEmployee(Employee employee) {
        return DatabaseManager.getInstance().saveEntry(employee);
    }

    @Override
    public Employee readEmployee(Long id) {
        return DatabaseManager.getInstance().getEntry(id, Employee.class);
    }

    @Override
    public void updateEmployee(Employee employee) {
        DatabaseManager.getInstance().updateEntry(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, Employee.class);
    }

    @Override
    public List<Employee> findAll() {
        return DatabaseManager.getInstance().getEntries(Employee.class);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        try (Session session = DatabaseManager.getInstance().getSessionFactory().getCurrentSession()) {
            return session
                    .createCriteria(Employee.class)
                    .add(Restrictions.eq("name", "Lora"))
                    .list();
        }
    }

    public List<Employee> getEmployeeBetweenAge(Integer from, Integer to) {
        try (Session session = DatabaseManager.getInstance().getSessionFactory().getCurrentSession()) {
            return session.createCriteria(Employee.class).add(Restrictions.between("age", from, to)).list();
        }
    }
}
