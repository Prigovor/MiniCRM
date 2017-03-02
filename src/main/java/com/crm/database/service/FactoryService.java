package com.crm.database.service;

import com.crm.database.dao.hibernate.HibernateDao;
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

    private static AccountService accountService = context.getBean(AccountService.class);
    public static AccountService getAccountService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                accountService.setDao(context.getBean("hibernateDaoAccount", HibernateDao.class));
                break;
            }
        }

        return accountService;
    }

    private static ClientService clientService = context.getBean(ClientService.class);
    public static ClientService getClientService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                clientService.setDao(context.getBean("hibernateDaoClient", HibernateDao.class));
                break;
            }
        }

        return clientService;
    }

    private static EmployeeService employeeService = context.getBean(EmployeeService.class);
    public static EmployeeService getEmployeeService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                employeeService.setDao(context.getBean("hibernateDaoEmployee", HibernateDao.class));
                break;
            }
        }

        return employeeService;
    }

    private static CourierService courierService = context.getBean(CourierService.class);
    public static CourierService getCourierService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                courierService.setDao(context.getBean("hibernateDaoCourier", HibernateDao.class));
                break;
            }
        }

        return courierService;
    }

    private static OrderManagerService orderManagerService = context.getBean(OrderManagerService.class);
    public static OrderManagerService getOrderManagerService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                orderManagerService.setDao(context.getBean("hibernateDaoOrderManager", HibernateDao.class));
                break;
            }
        }

        return orderManagerService;
    }

    private static StorekeeperService storekeeperService = context.getBean(StorekeeperService.class);
    public static StorekeeperService getStorekeeperService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                storekeeperService.setDao(context.getBean("hibernateDaoStorekeeper", HibernateDao.class));
                break;
            }
        }

        return storekeeperService;
    }

    private static GoodService goodService = context.getBean(GoodService.class);
    public static GoodService getGoodService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                goodService.setDao(context.getBean("hibernateDaoGood", HibernateDao.class));
                break;
            }
        }

        return goodService;
    }

    private static OrderService orderService = context.getBean(OrderService.class);
    public static OrderService getOrderService(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                orderService.setDao(context.getBean("hibernateDaoOrder", HibernateDao.class));
                break;
            }
        }

        return orderService;
    }
}
