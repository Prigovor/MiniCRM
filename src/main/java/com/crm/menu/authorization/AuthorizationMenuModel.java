package com.crm.menu.authorization;

import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.user.User;
import com.crm.main.Main;
import com.crm.main.MainModel;

import java.io.IOException;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AuthorizationMenuModel
{
    private UserDAO userDAO = new UserDAOImpl();

    public boolean authorize(String login, String password) throws IOException
    {
        for (User user : userDAO.findAll())
        {
            if (user.getLogin().equals(login) && user.getPassword().equals(password))
            {
                MainModel.getInstance().setCurrentUser(user);
                switch (MainModel.getInstance().getCurrentUser().getUserType())
                {
                    case ADMINISTRATOR:
                    {
                        Main.getInstance().replaceSceneContent("/com/crm/menu/view/admin_menu.fxml");
                        return true;
                    }
                    case EMPLOYEE:
                    {
                        Main.getInstance().replaceSceneContent("/com/crm/menu/view/employee_menu.fxml");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void createAccount() throws IOException
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/view/create_account_menu.fxml");
    }
}
