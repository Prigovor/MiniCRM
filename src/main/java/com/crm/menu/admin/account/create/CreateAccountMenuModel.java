package com.crm.menu.admin.account.create;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.employee.courier.CourierStatus;
import com.crm.managers.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.employee.EmployeeService;

import static com.crm.database.manager.DatabaseManagerType.HIBERNATE;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuModel
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
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public void createAccount()
    {
        switch (employee.getPosition())
        {
            case COURIER:
            {
                Courier courier = new Courier(employee.getName(), employee.getSurname(),
                        employee.getAge(), employee.getGender(), CourierStatus.FREE);

                FactoryService.getCourierService(HIBERNATE).saveEntry(courier);
                account.setEmployee(courier);

                break;
            }
            default:
            {
                employeeService.saveEntry(employee);
                account.setEmployee(employee);

                break;
            }
        }

        accountService.saveEntry(account);
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
