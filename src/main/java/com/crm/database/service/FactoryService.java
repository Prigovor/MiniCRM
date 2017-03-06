package com.crm.database.service;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.client.Client;
import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.employee.order_manager.OrderManager;
import com.crm.database.entity.employee.storekeeper.Storekeeper;
import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.manager.ContextManager;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.account.AccountService;
import com.crm.database.service.client.ClientService;
import com.crm.database.service.employee.EmployeeService;
import com.crm.database.service.employee.courier.CourierService;
import com.crm.database.service.employee.order_manager.OrderManagerService;
import com.crm.database.service.employee.storekeeper.StorekeeperService;
import com.crm.database.service.good.GoodService;
import com.crm.database.service.order.OrderService;
import org.springframework.context.ApplicationContext;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class FactoryService
{
    private static ApplicationContext context = ContextManager.getInstance().getContext();

    public static GenericService getService(DatabaseManagerType databaseManagerType, Class entityClass)
    {
        if (entityClass.equals(Account.class))
        {
            return getAccountService(databaseManagerType);
        }

        if (entityClass.equals(Client.class))
        {
            return getClientService(databaseManagerType);
        }

        if (entityClass.equals(Employee.class))
        {
            return getEmployeeService(databaseManagerType);
        }

        if (entityClass.equals(Courier.class))
        {
            return getClientService(databaseManagerType);
        }

        if (entityClass.equals(Storekeeper.class))
        {
            return getStorekeeperService(databaseManagerType);
        }

        if (entityClass.equals(OrderManager.class))
        {
            return getOrderManagerService(databaseManagerType);
        }

        if (entityClass.equals(Good.class))
        {
            return getGoodService(databaseManagerType);
        }

        if (entityClass.equals(SelectedGood.class))
        {
            return getSelectedGoodService(databaseManagerType);
        }

        if (entityClass.equals(Order.class))
        {
            return getOrderService(databaseManagerType);
        }

        return null;
    }

    public static AccountService getAccountService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("accountHibernateService", AccountService.class);
            }
        }

        return null;
    }

    public static ClientService getClientService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("clientHibernateService", ClientService.class);
            }
        }

        return null;
    }

    public static EmployeeService getEmployeeService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("employeeHibernateService", EmployeeService.class);
            }
        }

        return null;
    }

    public static CourierService getCourierService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("courierHibernateService", CourierService.class);
            }
        }

        return null;
    }

    public static OrderManagerService getOrderManagerService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("orderManagerHibernateService", OrderManagerService.class);
            }
        }

        return null;
    }

    public static StorekeeperService getStorekeeperService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("storekeeperHibernateService", StorekeeperService.class);
            }
        }

        return null;
    }

    public static GoodService getGoodService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("goodHibernateService", GoodService.class);
            }
        }

        return null;
    }

    public static GoodService getSelectedGoodService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("selectedGoodHibernateService", GoodService.class);
            }
        }

        return null;
    }

    public static OrderService getOrderService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("orderHibernateService", OrderService.class);
            }
        }

        return null;
    }
}
