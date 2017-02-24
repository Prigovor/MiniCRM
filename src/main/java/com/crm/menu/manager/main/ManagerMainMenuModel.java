package com.crm.menu.manager.main;

import com.crm.entity.client.Client;
import com.crm.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.manager.OrderManagerMenuModel;
import com.crm.service.client.ClientService;
import com.crm.service.client.ClientServiceImpl;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class ManagerMainMenuModel
{
    private OrderService orderService = new OrderServiceImpl();
    private ClientService clientService = new ClientServiceImpl();

    private Order selectedOrder;

    public Order getSelectedOrder()
    {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder)
    {
        this.selectedOrder = selectedOrder;
    }

    public List<Order> getListOrders()
    {
        return orderService.findAll();
    }

    public List<Client> getListClients()
    {
        return clientService.findAll();
    }

    public void addOrder()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/client-input-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }

    public void logOut()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }
}
