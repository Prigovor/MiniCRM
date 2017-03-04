package com.crm.menu.admin.account.create.data;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.RightType;
import com.crm.database.manager.PasswordManager;
import com.crm.database.validation.EntityValidator;
import com.crm.main.Main;
import com.crm.menu.admin.account.create.AccountCreationModel;

import java.util.Date;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class AccountDataModel
{
    public void setAccountData(String login, RightType rightType, LockType lockType)
    {
        Account account = AccountCreationModel.getInstance().getAccountToCreate();

        account.setLogin(login);
        account.setRightType(rightType);
        account.setLockType(lockType);

        account.setPassword(PasswordManager.getInstance().generatePassword(8));
        account.setRegistrationDate(new Date());

        EntityValidator.getInstance().validateAccount(account);
    }

    public void next()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/admin/chose-employee-menu.fxml");
    }

    public void cancel()
    {
        AccountCreationModel.getInstance().cancel();
    }
}
