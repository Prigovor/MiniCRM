package com.crm.menu.account.create;

import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.menu.admin.AdminMenuController;
import com.crm.service.UserValidationException;
import com.crm.main.Main;
import com.crm.service.user.UserService;
import com.crm.service.user.UserServiceImpl;

import java.io.IOException;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuModel
{
    private User user = new User();
    private Employee employee = new Employee();

    public User getUser()
    {
        return user;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    private UserDAO userDAO = new UserDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private UserService userService = new UserServiceImpl();

    public void createAccount() throws CreateAccountException, IOException, UserValidationException
    {
        if (user.getLogin() != null && user.getPassword() != null)
        {
            for (User userEntry : userDAO.findAll())
            {
                if (userEntry.getLogin().equals(user.getLogin()) || userEntry.getPassword().equals(user.getPassword()))
                {
                    throw new CreateAccountException("User with such login or password already exists");
                }
            }
        }

        if (employee.getName() != null && employee.getSurname() != null)
        {
            employeeDAO.createEmployee(employee);
            user.setEmployee(employee);
            userService.createUser(user);

            Main.getInstance().replaceSceneContent(new AdminMenuController());
        }
        else
        {
            throw new CreateAccountException("Enter your name and surname");
        }
    }
}
