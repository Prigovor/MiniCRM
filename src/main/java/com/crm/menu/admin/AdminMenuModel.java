package com.crm.menu.admin;

import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.service.UserValidationException;
import com.crm.service.employee.EmployeeService;
import com.crm.service.employee.EmployeeServiceImpl;
import com.crm.service.user.UserService;
import com.crm.service.user.UserServiceImpl;

import java.util.List;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AdminMenuModel
{
    private UserDAO userDAO = new UserDAOImpl();

    private UserService userService = new UserServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

    private User selectedUser;

    public List<User> getListUsers()
    {
        return userDAO.findAll();
    }

    public List<User> secureGetListUsers() throws UserValidationException
    {
        return userService.findAll();
    }

    public List<Employee> secureGetListEmployers() throws UserValidationException
    {
        return employeeService.findAll();
    }

    public User getSelectedUser()
    {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser)
    {
        this.selectedUser = selectedUser;
    }

    public void validateUser() throws UserValidationException
    {
        userService.validateUser();
    }

    public void deleteUser(User user) throws UserValidationException
    {
        userService.deleteUser(user.getId());
    }
}
