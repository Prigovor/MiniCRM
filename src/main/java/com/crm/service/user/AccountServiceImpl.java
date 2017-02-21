package com.crm.service.user;

import com.crm.dao.FactoryDAO;
import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.account.AccountDAO;
import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;
import com.crm.managers.EmailManager;
import com.crm.managers.PasswordManager;
import com.crm.service.UserValidationException;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class AccountServiceImpl implements AccountService
{
    private AccountDAO accountDAO = FactoryDAO.getAccountDAO();
    private EmployeeDAO employeeDAO = FactoryDAO.getEmployeeDAO();

    @Override
    public Long createUser(Account account) throws UserValidationException
    {
        validateUser();
        return accountDAO.createAccount(account);
    }

    @Override
    public Account readUser(Long id) throws UserValidationException
    {
        validateUser();
        return accountDAO.readAccount(id);
    }

    @Override
    public void updateUser(Account account) throws UserValidationException
    {
        validateUser();
        accountDAO.updateAccount(account);
    }

    @Override
    public void deleteUser(Long id) throws UserValidationException
    {
        validateUser();
        accountDAO.deleteAccount(id);
    }

    @Override
    public List<Account> findAll() throws UserValidationException
    {
        validateUser();
        return accountDAO.findAll();
    }

    @Override
    public void generateUserFromEmployee(Employee employee) throws UserValidationException, MessagingException
    {
        validateUser();

        Account account = new Account();
        account.setLogin(employee.getName().toLowerCase().concat(".").concat(employee.getSurname().toLowerCase()));
        account.setPassword(PasswordManager.getInstance().generatePassword(4));
        account.setEmail(employee.getWorkEmail());
        account.setEmployee(employee);

        int sameUserCount = 0;
        for (Account accountEntry : accountDAO.findAll())
        {
            if (account.getLogin().equals(accountEntry.getLogin()))
            {
                sameUserCount++;
            }

            if (account.getPassword().equals(accountEntry.getPassword()))
            {
                account.setPassword(PasswordManager.getInstance().generatePassword(4));
            }
        }

        if (sameUserCount != 0)
        {
            account.setLogin(account.getLogin().concat("." + sameUserCount));
        }

        employeeDAO.createEmployee(employee);
        accountDAO.createAccount(account);

        new Thread(() ->
        {
            try
            {
                EmailManager.getInstance().sendMessage(account.getEmail(), "Login and password from MiniSRM account",
                        "Login: " + account.getLogin() + "\nPassword: " + account.getPassword());
            }
            catch (MessagingException e)
            {

            }
        }).start();
    }

    @Override
    public void sendPasswordOnEmail(String email) throws UserValidationException, MessagingException
    {

    }
}
