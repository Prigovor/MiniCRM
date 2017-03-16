package com.crm.menu.order_manager.main;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import com.crm.database.service.client.ClientService;
import com.crm.database.service.order.OrderService;
import com.crm.main.Main;

import java.util.List;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class ManagerMainMenuModel
{
    private OrderService orderService = FactoryService.getOrderService();
    private ClientService clientService = FactoryService.getClientService();

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
        return orderService.getEntries();
    }

    public List<Client> getListClients()
    {
        return clientService.getEntries();
    }

    public void goToOrderManagement()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/management/order-management-menu.fxml");
    }

    public void goToOrderCreation()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/client/client-input-menu.fxml");
    }

    public void logOut()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
