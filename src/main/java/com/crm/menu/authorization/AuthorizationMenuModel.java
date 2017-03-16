package com.crm.menu.authorization;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.account.LockType;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import com.crm.main.Main;
import com.crm.main.MainModel;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AuthorizationMenuModel
{
    private static final int MAX_LOG_IN_ATTEMPTS = 3;

    private AccountService accountService = FactoryService.getAccountService();

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
                                Main.getInstance().replaceSceneContent("/com/crm/menu/admin/admin-main-menu.fxml");
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
                                        Main.getInstance().replaceSceneContent("/com/crm/menu/courier/courier-menu.fxml");
                                        break;
                                    }
                                    case ORDER_MANAGER:
                                    {
                                        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order-manager-main-menu.fxml");
                                        break;
                                    }
                                    case STOREKEEPER:
                                    {
                                        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/storekeeper-menu.fxml");
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
        Main.getInstance().replaceSceneContent("/com/crm/menu/password_recovery/phone_verification/phone-verification-menu.fxml");
    }

    public void exit()
    {
        Main.getInstance().exit();
    }
}
