package com.crm.menu.admin.account.create;

import com.crm.database.entity.account.Account;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.managers.EmailManager;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 03.03.2017.
 */
@Getter @Setter
public class AccountCreationModel
{
    private static final AccountCreationModel ourInstance = new AccountCreationModel();

    public static AccountCreationModel getInstance()
    {
        return ourInstance;
    }

    private AccountCreationModel()
    {
    }

    private Account accountToCreate = new Account();

    private String generatedPassword;

    public void saveAccount()
    {
        FactoryService.getAccountService().saveOrUpdate(accountToCreate);

        EmailManager.getInstance().sendAccountData(accountToCreate, generatedPassword);
    }

    public void close()
    {
        accountToCreate = new Account();
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/account/account-management-menu.fxml");
    }
}
