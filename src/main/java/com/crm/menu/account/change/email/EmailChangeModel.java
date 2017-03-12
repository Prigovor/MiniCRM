package com.crm.menu.account.change.email;

import com.crm.database.entity.account.Account;
import com.crm.database.validation.DataValidator;
import com.crm.menu.account.AccountMenuModel;

/**
 * Created by Bohdan on 10.03.2017.
 */
public class EmailChangeModel
{
    private Account account = AccountMenuModel.getInstance().getAccount();

    public void setNewEmail(String email)
    {
        DataValidator.getInstance().validateEmail(email);

        AccountMenuModel.getInstance().getAccount().getEmployee().setEmail(email);
    }

    public void confirm(String confirmationCode)
    {
        AccountMenuModel.getInstance().changeAccount(confirmationCode);
    }

    public void cancel()
    {

    }
}
