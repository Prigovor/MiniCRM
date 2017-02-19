package com.crm.menu.authorization;

import com.crm.dao.FactoryDAO;
import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.courier.Courier;
import com.crm.entity.good.Good;
import com.crm.entity.user.User;
import com.crm.main.MainModel;
import com.crm.managers.EmailManager;
import com.crm.service.UserValidationException;
import javafx.scene.control.TextInputDialog;
import org.springframework.context.support.GenericXmlApplicationContext;

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
            GenericXmlApplicationContext context = new GenericXmlApplicationContext("/spring-config/spring-config.xml");

            FactoryDAO.getUserDAO().createUser(context.getBean("userRoot", User.class));
            FactoryDAO.getUserDAO().createUser(context.getBean("userManagerAlan", User.class));

            FactoryDAO.getCourierDAO().createCourier(context.getBean("courierJane", Courier.class));

            FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopHP", Good.class));
            FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopAcer", Good.class));
            FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopAsus", Good.class));
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
                new Thread(() ->
                {
                    try
                    {
                        EmailManager.getInstance().sendMessage(result.get(), "Password remind", "Your password:\n" + listUsers.get(0).getPassword());
                    }
                    catch (MessagingException e)
                    {

                    }
                }).start();
            }
            else
            {
                throw new UserValidationException("User with such email is not registered");
            }
        }

        throw new UserValidationException("User with such email is not registered");
    }
}
