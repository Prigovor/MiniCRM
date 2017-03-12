package com.crm.menu.order_manager;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;

import java.util.ArrayList;
import java.util.List;

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

    private Employee employee = new Employee();

    public Employee getEmployee()
    {
        return employee;
    }

    private List<SelectedGood> listChosenGoods = new ArrayList<>();

    public List<SelectedGood> getListChosenGoods()
    {
        return listChosenGoods;
    }

    public void setListChosenGoods(List<SelectedGood> listChosenGoods)
    {
        this.listChosenGoods = listChosenGoods;
    }

    private List<Good> listStoreGoods = FactoryService.getGoodService().getEntries();

    public List<Good> getListStoreGoods()
    {
        return listStoreGoods;
    }

    public void setListStoreGoods(List<Good> listStoreGoods)
    {
        this.listStoreGoods = listStoreGoods;
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
