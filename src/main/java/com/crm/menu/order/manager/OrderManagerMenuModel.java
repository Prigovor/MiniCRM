package com.crm.menu.order.manager;

import com.crm.entity.client.Client;
import com.crm.entity.employee.Employee;
import com.crm.entity.order.Order;
import com.crm.main.MainModel;

/**
 * Created by Bohdan on 15.02.2017.
 */
public class OrderManagerMenuModel
{
    private Client client = new Client();

    public Client getClient()
    {
        return client;
    }

    private Order order = new Order();

    public Order getOrder()
    {
        return order;
    }

    private Employee employee = new Employee();// MainModel.getInstance().getCurrentUser().getEmployee();

    public Employee getEmployee()
    {
        return employee;
    }

    private static OrderManagerMenuModel instance;

    public static OrderManagerMenuModel getInstance()
    {
        if (instance == null)
        {
            instance = new OrderManagerMenuModel();
        }

        return instance;
    }
}
