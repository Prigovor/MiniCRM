package com.crm.menu.authorization;

import com.crm.dao.FactoryDAO;
import com.crm.dao.account.AccountDAO;
import com.crm.entity.account.LockType;
import com.crm.entity.account.Account;
import com.crm.main.Main;
import com.crm.main.MainModel;
import com.crm.managers.EmailManager;
import com.crm.service.AccountExistsException;
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
    private AccountDAO accountDAO = FactoryDAO.getAccountDAO();

    private Integer logInAttempts = 0;
    private static final int MAX_LOG_IN_ATTEMPTS = 3;

    public AuthorizationMenuModel()
    {
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

                        switch (account.getRightType())
                        {
                            case ADMIN:
                            {
                                Main.getInstance().replaceSceneContent("/fxml-files/admin-main-menu.fxml");
                                break;
                            }
                            case SUPER:
                            {
                                break;
                            }
                            case USER:
                            {
                                switch (account.getEmployee().getPosition())
                                {
                                    case COURIER:
                                    {
                                        Main.getInstance().replaceSceneContent("/fxml-files/courier-menu.fxml");
                                        break;
                                    }
                                    case MANAGER:
                                    {
                                        Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
                                        break;
                                    }
                                    case STOREKEEPER:
                                    {
                                        Main.getInstance().replaceSceneContent("/fxml-files/storekeeper-main-menu.fxml");
                                        break;
                                    }
                                    case CASHIER:
                                    {
                                        break;
                                    }
                                }
                            }
                        }

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

    public void remindPassword() throws AccountExistsException
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
                throw new AccountExistsException("Account with such email is not registered");
            }
        }

        throw new AccountExistsException("Account with such email is not registered");
    }
}
