package com.crm.database.manager;

import com.crm.database.service.FactoryService;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.client.ClientService;
import com.crm.database.service.employee.EmployeeService;

/**
 * Created by Bohdan on 02.03.2017.
 */
public class EntityChecker
{
    private static AccountService accountServiceHibernate = FactoryService.getAccountService(DatabaseManagerType.HIBERNATE);

    public static boolean isAccountWithLoginExists(String login)
    {
        return accountServiceHibernate.getEntryByField("login", login) != null;
    }

    public static boolean isAccountWithPasswordExists(String password)
    {
        return accountServiceHibernate.getEntryByField("password", password) != null;
    }

    public static boolean isAccountWithEmailExists(String email)
    {
        return accountServiceHibernate.getEntryByField("email", email) != null;
    }

    public static boolean isAccountWithPhoneExists(String phone)
    {
        return accountServiceHibernate.getEntryByField("phone", phone) != null;
    }


    private static ClientService clientServiceHibernate = FactoryService.getClientService(DatabaseManagerType.HIBERNATE);

    public static boolean isClientWithLoginExists(String login)
    {
        return clientServiceHibernate.getEntryByField("login", login) != null;
    }

    public static boolean isClientWithPasswordExists(String password)
    {
        return clientServiceHibernate.getEntryByField("password", password) != null;
    }

    public static boolean isClientWithEmailExists(String email)
    {
        return clientServiceHibernate.getEntryByField("email", email) != null;
    }

    public static boolean isClientWithPhoneExists(String phone)
    {
        return clientServiceHibernate.getEntryByField("phone", phone) != null;
    }


    private static EmployeeService employeeServiceHibernate = FactoryService.getEmployeeService(DatabaseManagerType.HIBERNATE);

    public static boolean isEmployeeWithEmailExists(String email)
    {
        return employeeServiceHibernate.getEntryByField("email", email) != null;
    }

    public static boolean isEmployeeWithPhoneExists(String phone)
    {
        return employeeServiceHibernate.getEntryByField("phone", phone) != null;
    }
}
