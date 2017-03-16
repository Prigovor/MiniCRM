package com.crm.menu.courier;

import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.service.FactoryService;
import com.crm.database.service.order.OrderService;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 26.02.2017.
 */
public class CourierMenuModel
{
    private OrderService orderService = FactoryService.getOrderService();

    private Order selectedOrder;

    public Order getSelectedOrder()
    {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder)
    {
        this.selectedOrder = selectedOrder;
    }

    public List<Order> getListOrdersDelivering()
    {
        List<Order> list = orderService.getEntries(order ->
        {
            Hibernate.initialize(order.getGoods());
        });

        return list.stream().filter(order ->
        {
            return order.getOrderStatus().equals(OrderStatus.DELIVERY_PROCESS);
        }).collect(Collectors.toList());
    }

    public void closeOrder(Order order)
    {
        if (order != null)
        {
            order.setOrderStatus(OrderStatus.CLOSED);
            orderService.updateEntry(order);
        }
    }
}
