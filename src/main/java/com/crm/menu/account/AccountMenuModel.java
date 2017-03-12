package com.crm.menu.account;

import com.crm.database.confirmation.ConfirmationManager;
import com.crm.database.entity.account.Account;
import com.crm.database.service.FactoryService;
import com.crm.main.MainModel;
import javafx.scene.control.Alert;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class AccountMenuModel
{
    private static final AccountMenuModel instance = new AccountMenuModel();

    public static AccountMenuModel getInstance()
    {
        return instance;
    }

    private Account account = MainModel.getInstance().getCurrentAccount();

    public Account getAccount()
    {
        return account;
    }

    public void changeAccount(String confirmationCode)
    {
        ConfirmationManager.doActionWithEmailConfirmation(account.getEmail(), confirmationCode,
                () ->
                {
                    FactoryService.getAccountService().updateEntry(account);
                    FactoryService.getEmployeeService().updateEntry(account.getEmployee());
                },
                () ->
                {
                    new Alert(Alert.AlertType.INFORMATION, "Enter correct confirmation code");
                });
    }

    public void exit()
    {

    }
}
