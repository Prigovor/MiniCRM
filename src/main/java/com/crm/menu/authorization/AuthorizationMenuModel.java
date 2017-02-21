package com.crm.menu.authorization;

import com.crm.dao.FactoryDAO;
import com.crm.dao.account.AccountDAO;
import com.crm.entity.account.LockType;
import com.crm.entity.courier.Courier;
import com.crm.entity.good.Good;
import com.crm.entity.account.Account;
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
    private AccountDAO accountDAO = FactoryDAO.getAccountDAO();

    private Integer logInAttempts = 0;
    private static final int MAX_LOG_IN_ATTEMPTS = 3;

    public AuthorizationMenuModel()
    {
        Thread thread = new Thread(() ->
        {
            GenericXmlApplicationContext context = new GenericXmlApplicationContext("/spring-config/spring-config.xml");

            FactoryDAO.getAccountDAO().createAccount(context.getBean("accountAdmin", Account.class));
            FactoryDAO.getAccountDAO().createAccount(context.getBean("accountManagerAlan", Account.class));

            FactoryDAO.getCourierDAO().createCourier(context.getBean("courierJane", Courier.class));

            FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopHP", Good.class));
            FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopAcer", Good.class));
            FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopAsus", Good.class));
        });

        thread.setDaemon(true);
        thread.start();
    }

    public AuthorizationResult authorize(String login, String password) throws IOException
    {
        Account account = accountDAO.getAccountByField("login", login);

        if (account != null)
        {
            if (account.getLockType().equals(LockType.UNLOCKED))
            {
                if (logInAttempts < MAX_LOG_IN_ATTEMPTS)
                {
                    if (account.getPassword().equals(password))
                    {
                        MainModel.getInstance().setCurrentAccount(account);
                        return AuthorizationResult.SUCCESSFUL;
                    }
                    else
                    {
                        logInAttempts++;
                    }
                }
                else
                {
                    account.setLockType(LockType.LOCKED);
                    accountDAO.updateAccount(account);
                }
            }
            else
            {
                return AuthorizationResult.LOCKED;
            }
        }

        return AuthorizationResult.INCORRECT_LOGIN_PASSWORD;
    }

    public void remindPassword() throws MessagingException, UserValidationException
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Password sending");
        dialog.setContentText("Enter your email");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            List<Account> listAccounts = accountDAO.getAccountsByField("email", result.get());

            if (!listAccounts.isEmpty())
            {
                new Thread(() ->
                {
                    try
                    {
                        EmailManager.getInstance().sendMessage(result.get(), "Password remind", "Your password:\n" + listAccounts.get(0).getPassword());
                    }
                    catch (MessagingException e)
                    {

                    }
                }).start();
            }
            else
            {
                throw new UserValidationException("Account with such email is not registered");
            }
        }

        throw new UserValidationException("Account with such email is not registered");
    }
}
