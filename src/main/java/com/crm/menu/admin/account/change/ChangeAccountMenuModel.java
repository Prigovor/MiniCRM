package com.crm.menu.admin.account.change;

import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.dao.account.AccountDAO;
import com.crm.dao.account.AccountDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;
import com.crm.main.Main;
import com.crm.main.MainModel;
import com.crm.managers.PasswordManager;
import com.crm.service.account.CreateAccountException;
import com.crm.service.account.AccountService;
import com.crm.service.account.AccountServiceImpl;
import com.crm.service.employee.EmployeeService;
import com.crm.service.employee.EmployeeServiceImpl;

import java.io.IOException;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class ChangeAccountMenuModel
{
    private Account account = new Account();
    private Employee employee = new Employee();

    private AccountService accountService = new AccountServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

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

    public void changeAccount() throws IOException, CreateAccountException
    {
        employeeService.updateEmployee(employee);
        account.setEmployee(employee);
        accountService.updateAccount(account);

        if (MainModel.getInstance().getCurrentAccount().getId().equals(account.getId()))
        {
            MainModel.getInstance().setCurrentAccount(account);
        }
    }

    public String generatePassword(int length)
    {
        String password = PasswordManager.getInstance().generatePassword(length);

        if (accountService.getAccountByField("password", password) != null)
        {
            password = PasswordManager.getInstance().generatePassword(length);
        }

        return password;
    }
}
