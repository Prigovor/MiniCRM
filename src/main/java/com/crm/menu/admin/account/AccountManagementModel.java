package com.crm.menu.admin.account;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.admin.account.create.AccountCreationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Bohdan on 06.03.2017.
 */
@Getter @Setter
public class AccountManagementModel
{
    private Account selectedAccount;

    public void addAccount()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/account/create/set-account-data-menu.fxml");
    }

    public void changeAccount()
    {
        AccountCreationModel.getInstance().setAccountToCreate(selectedAccount);
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/account/create/set-account-data-menu.fxml");
    }

    public void deleteAccount()
    {
        FactoryService.getAccountService().deleteEntry(selectedAccount.getId());
    }

    public void generateAccount()
    {

    }

    public List<Account> getListAccounts()
    {
        return FactoryService.getAccountService().getEntries();
    }

    public List<Employee> getListEmployers()
    {
        return FactoryService.getEmployeeService().getEntries();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/admin-main-menu.fxml");
    }
}
