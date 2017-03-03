package com.crm.menu.authorization;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.account.LockType;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import com.crm.main.Main;
import com.crm.main.MainModel;

import static com.crm.database.manager.DatabaseManagerType.HIBERNATE;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AuthorizationMenuModel
{
    private static final int MAX_LOG_IN_ATTEMPTS = 3;

    private AccountService accountService = FactoryService.getAccountService(HIBERNATE);

    private Integer logInAttempts = 0;

    public AuthorizationMenuModel()
    {
    }

    public void authorize(String login, String password)
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

                        return;
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
                throw new RuntimeException("Account is locked");
            }
        }

        throw new RuntimeException("Incorrect login or password");
    }

    public void remindPassword()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/password-recovery/phone-verification-menu.fxml");
    }

    public void exit()
    {
        Main.getInstance().exit();
    }
}
