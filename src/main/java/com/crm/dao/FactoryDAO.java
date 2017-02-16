package com.crm.dao;

import com.crm.dao.client.ClientDAO;
import com.crm.dao.client.ClientDAOImpl;
import com.crm.dao.courier.CourierDAO;
import com.crm.dao.courier.CourierDAOImpl;
import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.employee.EmployeeDAOImpl;
import com.crm.dao.good.GoodDAO;
import com.crm.dao.good.GoodDAOImpl;
import com.crm.dao.order.OrderDAO;
import com.crm.dao.order.OrderDAOImpl;
import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;

/**
 * Created by Bohdan on 12.02.2017.
 */
public final class FactoryDAO {

    private static UserDAO userDAO;

    public static UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    private static EmployeeDAO employeeDAO;

    public static EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    private static ClientDAO clientDAO;

    public static ClientDAO getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    private static GoodDAO goodDAO;

    public static GoodDAO getGoodDAO() {
        if (goodDAO == null) {
            goodDAO = new GoodDAOImpl();
        }
        return goodDAO;
    }

    private static OrderDAO orderDAO;

    public static OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }

    private static CourierDAO courierDAO;

    public static CourierDAO getCourierDAO() {
        if (courierDAO == null) {
            courierDAO = new CourierDAOImpl();
        }
        return courierDAO;
    }
}