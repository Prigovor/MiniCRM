package com.crm.menu.admin.account.create;

import com.crm.database.entity.account.Account;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
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

    public void saveAccount()
    {
        FactoryService.getAccountService(DatabaseManagerType.HIBERNATE).saveOrUpdate(accountToCreate);
    }

    public void cancel()
    {
        accountToCreate = new Account();
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/admin-main-menu.fxml");
    }
}
