package com.crm.menu.authorization;

import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.Account;
import com.crm.database.manager.PasswordManager;
import com.crm.main.Main;
import com.crm.main.MainModel;
import com.crm.managers.EmailManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.crm.database.manager.DatabaseManagerType.*;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AuthorizationMenuModel
{
    private AccountService accountService = FactoryService.getAccountService(HIBERNATE);

    private Integer logInAttempts = 0;
    private static final int MAX_LOG_IN_ATTEMPTS = 3;

    public AuthorizationMenuModel()
    {
    }

    public AuthorizationResult authorize(String login, String password) throws IOException
    {
        Account account = accountService.getEntryByField("login", login);

        if (account != null)
        {
            if (account.getLockType().equals(LockType.UNLOCKED))
            {
                if (logInAttempts < MAX_LOG_IN_ATTEMPTS)
                {
                    if (PasswordManager.getInstance().isPasswordCorrect(password, account.getPassword()))
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
                                    case ORDER_MANAGER:
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
                    accountService.updateEntry(account);
                }
            }
            else
            {
                return AuthorizationResult.LOCKED;
            }
        }

        return AuthorizationResult.INCORRECT_LOGIN_PASSWORD;
    }

    public void remindPassword()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Password sending");
        dialog.setContentText("Enter your email");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            List<Account> listAccounts = accountService.getEntriesByField("email", result.get());

            if (!listAccounts.isEmpty())
            {
                EmailManager.getInstance().sendMessage(result.get(), "Password remind", "Your password:\n" + listAccounts.get(0).getPassword());
            }
            else
            {
                throw new RuntimeException("Account with such email is not registered");
            }
        }

        throw new RuntimeException("Account with such email is not registered");
    }
}
