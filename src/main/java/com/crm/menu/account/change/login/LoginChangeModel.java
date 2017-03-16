package com.crm.menu.account.change.login;

import com.crm.database.entity.account.Account;
import com.crm.database.validation.DataValidator;
import com.crm.menu.account.AccountMenuModel;

/**
 * Created by Bohdan on 10.03.2017.
 */
public class LoginChangeModel
{
    private Account account = AccountMenuModel.getInstance().getAccount();

    public void setNewLogin(String login)
    {
        DataValidator.getInstance().validateLogin(login);

        AccountMenuModel.getInstance().getAccount().setLogin(login);
    }

    public void confirm(String confirmationCode)
    {
        AccountMenuModel.getInstance().changeAccount(confirmationCode);
    }

    public void cancel()
    {

    }
}
