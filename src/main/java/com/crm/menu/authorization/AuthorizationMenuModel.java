package com.crm.menu.authorization;

import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.client.Client;
import com.crm.entity.employee.Employee;
import com.crm.entity.good.Good;
import com.crm.entity.order.Order;
import com.crm.entity.user.User;
import com.crm.main.MainModel;
import com.crm.managers.DatabaseManager;
import com.crm.managers.EmailManager;
import com.crm.service.UserValidationException;
import javafx.scene.control.TextInputDialog;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
            DatabaseManager.getInstance().configure("hibernate.cfg.xml", User.class, Employee.class, Client.class, Good.class, Order.class);
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

    public void remindPassword() throws MessagingException, UserValidationException
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Password sending");
        dialog.setContentText("Enter your email");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            List<User> listUsers = userDAO.getUsersByField("email", result.get());

            if (!listUsers.isEmpty())
            {
                EmailManager.getInstance().sendMessage(result.get(), "Password remind", "Your password:\n" + listUsers.get(0).getPassword());
            }
            else
            {
                throw new UserValidationException("User with such email is not registered");
            }
        }

        throw new UserValidationException("User with such email is not registered");
    }
}
