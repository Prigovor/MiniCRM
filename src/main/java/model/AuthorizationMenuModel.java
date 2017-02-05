package model;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import entity.User;
import main.Main;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AuthorizationMenuModel
{
    private UserDAO userDAO = new UserDAOImpl();

    private MainModel mainModel = MainModel.getInstance();

    public boolean authorize(String login, String password)
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
