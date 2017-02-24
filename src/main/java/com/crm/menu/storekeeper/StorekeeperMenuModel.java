package com.crm.menu.storekeeper;

import com.crm.entity.good.Good;
import com.crm.entity.order.Order;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;

import java.util.List;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class StorekeeperMenuModel
{
    private OrderService orderService = new OrderServiceImpl();
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
}
