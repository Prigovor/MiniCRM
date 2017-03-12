package com.crm.menu.account.change.password;

import com.crm.database.entity.account.Account;
import com.crm.database.validation.DataValidator;
import com.crm.menu.account.AccountMenuModel;

/**
 * Created by Bohdan on 10.03.2017.
 */
public class PasswordChangeModel
{
    private Account account = AccountMenuModel.getInstance().getAccount();

    public void setNewPassword(String password)
    {
        DataValidator.getInstance().validatePassword(password);

        AccountMenuModel.getInstance().getAccount().setPassword(password);
    }

    public void confirm(String confirmationCode)
    {
        AccountMenuModel.getInstance().changeAccount(confirmationCode);
    }

    public void cancel()
    {

    }
}
