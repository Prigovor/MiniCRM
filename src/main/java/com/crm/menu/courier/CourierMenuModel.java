package com.crm.menu.courier;

import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;
import com.crm.service.good.GoodService;
import com.crm.service.good.GoodServiceImpl;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 26.02.2017.
 */
public class CourierMenuModel
{
    private OrderService orderService = new OrderServiceImpl();
    private GoodService goodService = new GoodServiceImpl();

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
        List<Order> list = orderService.findAllEager();
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
            orderService.updateOrder(order);
        }
    }
}
