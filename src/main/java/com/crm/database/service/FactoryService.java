package com.crm.database.service;

import com.crm.database.dao.FactoryDao;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.client.ClientService;
import com.crm.database.service.courier.CourierService;
import com.crm.database.service.order.OrderService;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.employee.EmployeeService;
import com.crm.database.service.good.GoodService;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class FactoryService
{
    private static final AccountService accountServiceHibernate = new AccountService(FactoryDao.getAccountDao(DatabaseManagerType.HIBERNATE));

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

    private static final ClientService clientServiceHibernate = new ClientService(FactoryDao.getClientDao(DatabaseManagerType.HIBERNATE));

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

    private static final CourierService courierServiceHibernate = new CourierService(FactoryDao.getCourierDao(DatabaseManagerType.HIBERNATE));

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

    private static final EmployeeService employeeServiceHibernate = new EmployeeService(FactoryDao.getEmployeeDao(DatabaseManagerType.HIBERNATE));

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

    private static final GoodService goodServiceHibernate = new GoodService(FactoryDao.getGoodDao(DatabaseManagerType.HIBERNATE));

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

    private static final OrderService orderServiceHibernate = new OrderService(FactoryDao.getOrderDao(DatabaseManagerType.HIBERNATE));

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
