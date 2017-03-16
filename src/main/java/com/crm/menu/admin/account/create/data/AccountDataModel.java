package com.crm.menu.admin.account.create.data;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.RightType;
import com.crm.database.manager.PasswordManager;
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

        AccountCreationModel.getInstance().setGeneratedPassword(PasswordManager.getInstance().generatePassword(8));

        account.setPassword(AccountCreationModel.getInstance().getGeneratedPassword());
        account.setRegistrationDate(new Date());
    }

    public void next()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/account/create/chose-employee-menu.fxml");
    }

    public void cancel()
    {
        AccountCreationModel.getInstance().close();
    }
}
