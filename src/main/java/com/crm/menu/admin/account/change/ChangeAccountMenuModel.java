package com.crm.menu.admin.account.change;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
import com.crm.main.MainModel;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.employee.EmployeeService;

import java.io.IOException;

import static com.crm.database.manager.DatabaseManagerType.HIBERNATE;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class ChangeAccountMenuModel
{
    private Account account = new Account();
    private Employee employee = new Employee();

    private AccountService accountService = FactoryService.getAccountService(HIBERNATE);
    private EmployeeService employeeService = FactoryService.getEmployeeService(HIBERNATE);

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
        if (account.getEmployee() != null)
        {
            employee = account.getEmployee();
        }
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void changeAccount() throws IOException
    {
        employeeService.updateEntry(employee);
        account.setEmployee(employee);
        accountService.updateEntry(account);

        if (MainModel.getInstance().getCurrentAccount().getId().equals(account.getId()))
        {
            MainModel.getInstance().setCurrentAccount(account);
        }
    }

    public String generatePassword(int length)
    {
        String password = PasswordManager.getInstance().generatePassword(length);

        if (accountService.getEntryByField("password", password) != null)
        {
            password = PasswordManager.getInstance().generatePassword(length);
        }

        return password;
    }
}
