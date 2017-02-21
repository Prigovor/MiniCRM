package com.crm.menu.order.manager;

import com.crm.entity.client.Client;
import com.crm.entity.courier.Courier;
import com.crm.entity.employee.Employee;
import com.crm.entity.order.Order;

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

    public void setClient(Client client)
    {
        this.client = client;
    }

    private Courier courier = new Courier();

    public Courier getCourier()
    {
        return courier;
    }

    public void setCourier(Courier courier)
    {
        this.courier = courier;
    }

    private Order order = new Order();

    public Order getOrder()
    {
        return order;
    }

    private Employee employee = new Employee();// MainModel.getInstance().getCurrentAccount().getEmployee();

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

    public void clearData()
    {
        instance = new OrderManagerMenuModel();
    }
}
