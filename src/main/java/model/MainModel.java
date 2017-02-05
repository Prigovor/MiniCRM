package model;

import entity.Employee;
import entity.User;
import managers.DatabaseManager;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class MainModel
{
    private static MainModel instance;

    public static MainModel getInstance()
    {
        if (instance == null)
        {
            instance = new MainModel();
        }

        return instance;
    }

    private MainModel()
    {
        DatabaseManager.getInstance().configure("hibernate.cfg.xml", User.class, Employee.class);
    }

    private User currentUser;

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }
}
