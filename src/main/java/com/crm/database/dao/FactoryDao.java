package com.crm.database.dao;

import com.crm.database.dao.hibernate.HibernateDao;
import com.crm.database.entity.account.Account;
import com.crm.database.entity.client.Client;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.good.Good;
import com.crm.database.entity.order.Order;
import com.crm.database.manager.DatabaseManagerType;

/**
 * Created by Bohdan on 12.02.2017.
 */
public final class FactoryDao
{
    private static final HibernateDao<Account, Long> accountDaoHibernate = new HibernateDao<>(Account.class);

    public static GenericDao<Account, Long> getAccountDao(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return accountDaoHibernate;
            }
        }
        return accountDaoHibernate;
    }

    private static final HibernateDao<Employee, Long> employeeDaoHibernate = new HibernateDao<>(Employee.class);

    public static GenericDao<Employee, Long> getEmployeeDao(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return employeeDaoHibernate;
            }
        }
        return employeeDaoHibernate;
    }

    private static final HibernateDao<Client, Long> clientDaoHibernate = new HibernateDao<>(Client.class);

    public static GenericDao<Client, Long> getClientDao(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return clientDaoHibernate;
            }
        }
        return clientDaoHibernate;
    }

    private static final HibernateDao<Good, Long> goodDaoHibernate = new HibernateDao<>(Good.class);

    public static GenericDao<Good, Long> getGoodDao(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return goodDaoHibernate;
            }
        }
        return goodDaoHibernate;
    }

    private static final HibernateDao<Order, Long> orderDaoHibernate = new HibernateDao<>(Order.class);

    public static GenericDao<Order, Long> getOrderDao(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return orderDaoHibernate;
            }
        }
        return orderDaoHibernate;
    }

    private static final HibernateDao<Courier, Long> courierDaoHibernate = new HibernateDao<>(Courier.class);

    public static GenericDao<Courier, Long> getCourierDao(DatabaseManagerType databaseManagerType)
    {
        switch (databaseManagerType)
        {
            case HIBERNATE:
            {
                return courierDaoHibernate;
            }
        }
        return courierDaoHibernate;
    }
}