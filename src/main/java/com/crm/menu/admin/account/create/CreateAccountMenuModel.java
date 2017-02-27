package com.crm.menu.admin.account.create;

import com.crm.dao.FactoryDao;
import com.crm.entity.employee.Employee;
import com.crm.entity.employee.courier.Courier;
import com.crm.entity.employee.courier.CourierStatus;
import com.crm.entity.account.Account;
import com.crm.managers.PasswordManager;
import com.crm.service.account.AccountService;
import com.crm.service.account.AccountServiceImpl;
import com.crm.service.employee.EmployeeService;
import com.crm.service.employee.EmployeeServiceImpl;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuModel
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
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public void createAccount() throws CreateAccountException
    {
        switch (employee.getPosition())
        {
            case COURIER:
            {
                Courier courier = new Courier(employee.getName(), employee.getSurname(),
                        employee.getAge(), employee.getGender(), CourierStatus.FREE);

                FactoryDao.getCourierDao().createCourier(courier);
                account.setEmployee(courier);

                break;
            }
            default:
            {
                employeeService.createEmployee(employee);
                account.setEmployee(employee);

                break;
            }
        }

        accountService.createAccount(account);
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
