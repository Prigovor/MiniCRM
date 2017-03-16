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
import com.crm.database.service.good.selected_good.SelectedGoodService;
import com.crm.database.service.order.OrderService;
import org.springframework.context.ApplicationContext;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class FactoryService
{
    private static ApplicationContext context = ContextManager.getInstance().getContext();

    private static DatabaseManagerType databaseManagerType = DatabaseManagerType.HIBERNATE;

    public static GenericService getService(Class entityClass)
    {
        if (entityClass.equals(Account.class))
        {
            return getAccountService();
        }

        if (entityClass.equals(Client.class))
        {
            return getClientService();
        }

        if (entityClass.equals(Employee.class))
        {
            return getEmployeeService();
        }

        if (entityClass.equals(Courier.class))
        {
            return getClientService();
        }

        if (entityClass.equals(Storekeeper.class))
        {
            return getStorekeeperService();
        }

        if (entityClass.equals(OrderManager.class))
        {
            return getOrderManagerService();
        }

        if (entityClass.equals(Good.class))
        {
            return getGoodService();
        }

        if (entityClass.equals(SelectedGood.class))
        {
            return getSelectedGoodService();
        }

        if (entityClass.equals(Order.class))
        {
            return getOrderService();
        }

        return null;
    }

    public static AccountService getAccountService()
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

    public static ClientService getClientService()
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

    public static EmployeeService getEmployeeService()
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

    public static CourierService getCourierService()
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

    public static OrderManagerService getOrderManagerService()
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

    public static StorekeeperService getStorekeeperService()
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

    public static GoodService getGoodService()
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

    public static SelectedGoodService getSelectedGoodService()
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return context.getBean("selectedGoodHibernateService", SelectedGoodService.class);
            }
        }

        return null;
    }

    public static OrderService getOrderService()
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
