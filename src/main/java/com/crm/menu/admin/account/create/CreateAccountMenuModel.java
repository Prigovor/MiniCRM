package com.crm.menu.admin.account.create;

import com.crm.dao.FactoryDAO;
import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.dao.account.AccountDAO;
import com.crm.dao.account.AccountDAOImpl;
import com.crm.entity.employee.Employee;
import com.crm.entity.courier.Courier;
import com.crm.entity.courier.CourierStatus;
import com.crm.entity.account.Account;
import com.crm.managers.PasswordManager;
import com.crm.service.account.AccountService;
import com.crm.service.account.AccountServiceImpl;

import java.io.IOException;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuModel
{
    private Account account = new Account();
    private Employee employee = new Employee();

    public Account getAccount()
    {
        return account;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    private AccountDAO accountDAO = new AccountDAOImpl();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private AccountService accountService = new AccountServiceImpl();

    public void createAccount() throws CreateAccountException, IOException
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

            if (!employee.getName().isEmpty() && !employee.getSurname().isEmpty())
            {
                switch (employee.getPosition())
                {
                    case COURIER:
                    {
                        Courier courier = new Courier(employee.getName(), employee.getSurname(),
                                employee.getAge(), employee.getGender(), CourierStatus.FREE);

                        FactoryDAO.getCourierDAO().createCourier(courier);
                        account.setEmployee(courier);

                        break;
                    }
                    default:
                    {
                        employeeDAO.createEmployee(employee);
                        account.setEmployee(employee);

                        break;
                    }
                }

                accountService.createAccount(account);
            }
            else
            {
                throw new CreateAccountException("Enter name and surname of employee");
            }
        }
        else
        {
            throw new CreateAccountException("Enter login and password");
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
