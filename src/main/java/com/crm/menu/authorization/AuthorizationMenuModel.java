package com.crm.menu.authorization;

import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.main.MainModel;
import com.crm.managers.DatabaseManager;

import java.io.IOException;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AuthorizationMenuModel
{
    private UserDAO userDAO = new UserDAOImpl();

    public AuthorizationMenuModel()
    {
        Thread thread = new Thread(() ->
        {
            DatabaseManager.getInstance().configure("hibernate.cfg.xml", User.class, Employee.class);
        });
        thread.setDaemon(true);
        thread.start();
    }

    public boolean authorize(String login, String password) throws IOException
    {
        for (User user : userDAO.findAll())
        {
            if (user.getLogin().equals(login) && user.getPassword().equals(password))
            {
                MainModel.getInstance().setCurrentUser(user);
                return true;
            }
        }
        return false;
    }
}
