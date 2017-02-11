package com.crm.menu.account.change;

import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.main.Main;
import com.crm.menu.account.create.CreateAccountException;
import com.crm.menu.admin.AdminMenuController;
import com.crm.service.UserValidationException;
import com.crm.service.user.UserService;
import com.crm.service.user.UserServiceImpl;

import java.io.IOException;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class ChangeAccountMenuModel
{
    private User user;
    private Employee employee;

    private UserDAO userDAO = new UserDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private UserService userService = new UserServiceImpl();

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
        employee = user.getEmployee();
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void changeAccount() throws CreateAccountException, IOException, UserValidationException
    {
        if (employee.getName() != null && employee.getSurname() != null)
        {
            employeeDAO.updateEmployee(employee);
            user.setEmployee(employee);
            userService.updateUser(user);

            Main.getInstance().replaceSceneContent(new AdminMenuController());
        }
        else
        {
            throw new CreateAccountException("Enter name and surname of employee");
        }
    }

    public void checkAccountSameLoginPassword() throws CreateAccountException
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
    }
}
