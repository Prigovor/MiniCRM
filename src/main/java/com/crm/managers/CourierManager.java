package com.crm.managers;

import com.crm.entity.courier.Courier;
import com.crm.entity.courier.Status;
import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;

import javax.mail.MessagingException;

/**
 * Created by Bohdan on 15.02.2017.
 */
public class CourierManager {

    private static CourierManager instance;

    public static CourierManager getInstance() {
        if (instance == null) {
            instance = new CourierManager();
        }
        return instance;
    }

    private CourierManager() {
    }

    private OrderService orderService = new OrderServiceImpl();

    public void orderDelivery(Courier courier, Order order) throws MessagingException {
        if (courier != null && order != null) {
            order.setCourier(courier);
            order.getCourier().setStatus(Status.BUSY);
            order.setOrderStatus(OrderStatus.DELIVERY_PROCESS);
            orderService.updateOrder(order);

            EmailManager.getInstance().sendMessage(order.getClient().getEmail(), "123", "Your order number: " + order.getId());
        }
    }

    public void orderDelivered(Order order) {

    }
}