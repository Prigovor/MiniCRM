package com.crm.menu.admin;

import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;
import com.crm.service.employee.EmployeeService;
import com.crm.service.employee.EmployeeServiceImpl;
import com.crm.service.account.AccountService;
import com.crm.service.account.AccountServiceImpl;

import javax.mail.MessagingException;
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

    public void deleteAccount(Account account)
    {
        accountService.deleteAccount(account.getId());
        selectedAccount = null;
    }

    public void generateAccount(Employee employee) throws MessagingException
    {
        accountService.generateAccountFromEmployee(employee);
    }
}
