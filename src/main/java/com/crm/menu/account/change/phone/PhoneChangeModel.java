package com.crm.menu.account.change.phone;

import com.crm.database.entity.account.Account;
import com.crm.database.validation.DataValidator;
import com.crm.menu.account.AccountMenuModel;

/**
 * Created by Bohdan on 10.03.2017.
 */
public class PhoneChangeModel
{
    private Account account = AccountMenuModel.getInstance().getAccount();

    public void setNewPhone(String phone)
    {
        DataValidator.getInstance().validatePhone(phone);

        AccountMenuModel.getInstance().getAccount().getEmployee().setPhone(phone);
    }

    public void confirm(String confirmationCode)
    {
        AccountMenuModel.getInstance().changeAccount(confirmationCode);
    }

    public void cancel()
    {

    }
}
