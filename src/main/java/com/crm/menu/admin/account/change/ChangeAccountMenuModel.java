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
import com.crm.menu.admin.account.create.CreateAccountException;
import com.crm.menu.admin.AdminMenuController;
import com.crm.service.UserValidationException;
import com.crm.service.user.AccountService;
import com.crm.service.user.AccountServiceImpl;

import java.io.IOException;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class ChangeAccountMenuModel
{
    private Account account;
    private Employee employee = new Employee();

    private AccountDAO accountDAO = new AccountDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private AccountService accountService = new AccountServiceImpl();

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
        if (account.getEmployee() != null) {
            employee = account.getEmployee();
        }
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void changeAccount() throws CreateAccountException, IOException, UserValidationException
    {
        if (!employee.getName().isEmpty() && !employee.getSurname().isEmpty())
        {
            employeeDAO.updateEmployee(employee);
            account.setEmployee(employee);
            accountService.updateUser(account);

            if (MainModel.getInstance().getCurrentAccount().getId().equals(account.getId()))
            {
                MainModel.getInstance().setCurrentAccount(account);
            }
            Main.getInstance().replaceSceneContent(new AdminMenuController());
        }
        else
        {
            throw new CreateAccountException("Enter name and surname of employee");
        }
    }

    public void checkAccountSameLoginPassword() throws CreateAccountException
    {
        if (!account.getLogin().isEmpty() && !account.getPassword().isEmpty())
        {
            for (Account accountEntry : accountDAO.findAll())
            {
                if (accountEntry.getLogin().equals(account.getLogin()) || accountEntry.getPassword().equals(account.getPassword()))
                {
                    throw new CreateAccountException("Account with such login or password already exists");
                }
            }
        }
    }

    public String generatePassword(int length)
    {
        String password = PasswordManager.getInstance().generatePassword(length);

        for (Account accountEntry : accountDAO.findAll())
        {
            if (password.equals(accountEntry.getPassword()))
            {
                password = PasswordManager.getInstance().generatePassword(length);
            }
        }

        return password;
    }
}
