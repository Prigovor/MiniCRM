package com.crm.menu.admin;

import com.crm.dao.account.AccountDAO;
import com.crm.dao.account.AccountDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;
import com.crm.service.UserValidationException;
import com.crm.service.employee.EmployeeService;
import com.crm.service.employee.EmployeeServiceImpl;
import com.crm.service.user.AccountService;
import com.crm.service.user.AccountServiceImpl;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AdminMenuModel
{
    private AccountDAO accountDAO = new AccountDAOImpl();

    private AccountService accountService = new AccountServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

    private Account selectedAccount;

    public List<Account> getListUsers()
    {
        return accountDAO.findAll();
    }

    public List<Account> secureGetListUsers() throws UserValidationException
    {
        return accountService.findAll();
    }

    public List<Employee> secureGetListEmployers() throws UserValidationException
    {
        return employeeService.findAll();
    }

    public Account getSelectedAccount()
    {
        return selectedAccount;
    }

    public void setSelectedAccount(Account selectedAccount)
    {
        this.selectedAccount = selectedAccount;
    }

    public void validateUser() throws UserValidationException
    {
        accountService.validateUser();
    }

    public void deleteUser(Account account) throws UserValidationException
    {
        accountService.deleteUser(account.getId());
        selectedAccount = null;
    }

    public void generateUser(Employee employee) throws UserValidationException, MessagingException
    {
        accountService.generateUserFromEmployee(employee);
    }
}
