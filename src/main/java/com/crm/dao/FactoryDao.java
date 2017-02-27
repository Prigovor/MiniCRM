package com.crm.dao;

import com.crm.dao.hibernate.HibernateDao;
import com.crm.entity.account.Account;
import com.crm.entity.client.Client;
import com.crm.entity.employee.courier.Courier;
import com.crm.entity.employee.Employee;
import com.crm.entity.good.Good;
import com.crm.entity.order.Order;

/**
 * Created by Bohdan on 12.02.2017.
 */
public final class FactoryDao
{
    private static final HibernateDao<Account, Long> accountDao = new HibernateDao<>(Account.class);

    public static HibernateDao<Account, Long> getAccountDao()
    {
        return accountDao;
    }

    private static final HibernateDao<Employee, Long> employeeDao = new HibernateDao<>(Employee.class);

    public static HibernateDao<Employee, Long> getEmployeeDao()
    {
        return employeeDao;
    }

    private static final HibernateDao<Client, Long> clientDao = new HibernateDao<>(Client.class);

    public static HibernateDao<Client, Long> getClientDao()
    {
        return clientDao;
    }

    private static final HibernateDao<Good, Long> goodDao = new HibernateDao<>(Good.class);

    public static HibernateDao<Good, Long> getGoodDao()
    {
        return goodDao;
    }

    private static final HibernateDao<Order, Long> orderDao = new HibernateDao<>(Order.class);

    public static HibernateDao<Order, Long> getOrderDao()
    {
        return orderDao;
    }

    private static final HibernateDao<Courier, Long> courierDao = new HibernateDao<>(Courier.class);

    public static HibernateDao<Courier, Long> getCourierDao()
    {
        return courierDao;
    }
}