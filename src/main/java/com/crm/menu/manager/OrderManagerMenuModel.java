package com.crm.menu.manager;

import com.crm.dao.FactoryDAO;
import com.crm.entity.client.Client;
import com.crm.entity.courier.Courier;
import com.crm.entity.employee.Employee;
import com.crm.entity.good.Good;
import com.crm.entity.selected_good.SelectedGood;
import com.crm.entity.order.Order;

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

    private List<Good> listStoreGoods = FactoryDAO.getGoodDAO().findAllStoreGoods();

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
