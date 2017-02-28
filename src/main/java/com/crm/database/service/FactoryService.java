package com.crm.database.service;

import com.crm.database.manager.ContextManager;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.client.ClientService;
import com.crm.database.service.courier.CourierService;
import com.crm.database.service.employee.EmployeeService;
import com.crm.database.service.good.GoodService;
import com.crm.database.service.order.OrderService;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class FactoryService
{
    private static AccountService accountServiceHibernate =
            ContextManager.getInstance().getContext().getBean(AccountService.class);

    public static AccountService getAccountService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return accountServiceHibernate;
            }
        }
        return accountServiceHibernate;
    }

    private static ClientService clientServiceHibernate = null;
    public static ClientService getClientService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return clientServiceHibernate;
            }
        }

        return clientServiceHibernate;
    }

    private static CourierService courierServiceHibernate = null;
    public static CourierService getCourierService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return courierServiceHibernate;
            }
        }

        return courierServiceHibernate;
    }

    private static EmployeeService employeeServiceHibernate = null;
    public static EmployeeService getEmployeeService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return employeeServiceHibernate;
            }
        }

        return employeeServiceHibernate;
    }

    private static GoodService goodServiceHibernate = null;
    public static GoodService getGoodService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return goodServiceHibernate;
            }
        }

        return goodServiceHibernate;
    }

    private static OrderService orderServiceHibernate = null;
    public static OrderService getOrderService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return orderServiceHibernate;
            }
        }

        return orderServiceHibernate;
    }
}
