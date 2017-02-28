package com.crm.menu.admin;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.employee.EmployeeService;

import java.util.List;

import static com.crm.database.manager.DatabaseManagerType.HIBERNATE;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AdminMenuModel
{
    private static final AdminMenuModel instance = new AdminMenuModel();

    public static AdminMenuModel getInstance()
    {
        return instance;
    }

    private AdminMenuModel()
    {

    }

    private AccountService accountService = FactoryService.getAccountService(HIBERNATE);
    private EmployeeService employeeService = FactoryService.getEmployeeService(HIBERNATE);

    private Account selectedAccount;

    public Account getSelectedAccount()
    {
        return selectedAccount;
    }

    public void setSelectedAccount(Account selectedAccount)
    {
        this.selectedAccount = selectedAccount;
    }

    public List<Account> getListAccounts()
    {
        return accountService.getEntries();
    }

    public List<Employee> getListEmployers()
    {
        return employeeService.getEntries();
    }

    public void deleteAccount()
    {
        accountService.deleteEntry(selectedAccount.getId());
        selectedAccount = null;
    }

    public void generateAccount(String filePath)
    {

    }
}
