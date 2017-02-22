package com.crm.menu.admin;

import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;
import com.crm.main.MainModel;
import com.crm.managers.JsonFileManager;
import com.crm.service.employee.EmployeeService;
import com.crm.service.employee.EmployeeServiceImpl;
import com.crm.service.account.AccountService;
import com.crm.service.account.AccountServiceImpl;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

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

    private AccountService accountService = new AccountServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

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
        return accountService.findAll();
    }

    public List<Employee> getListEmployers()
    {
        return employeeService.findAll();
    }

    public void deleteAccount()
    {
        accountService.deleteAccount(selectedAccount.getId());
        selectedAccount = null;
    }

    public void generateAccount(String filePath) throws MessagingException, IOException
    {
        accountService.generateAccountFromEmployee(JsonFileManager.deserializeFromJsonFile(Employee.class, filePath));
    }
}
