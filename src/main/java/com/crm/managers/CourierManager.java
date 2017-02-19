package com.crm.managers;

import com.crm.entity.courier.Courier;
import com.crm.entity.courier.CourierStatus;
import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;
import com.crm.service.courier.CourierService;
import com.crm.service.courier.CourierServiceImpl;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;

import javax.mail.MessagingException;

/**
 * Created by Bohdan on 15.02.2017.
 */
public class CourierManager
{
    private static CourierManager instance;

    public static CourierManager getInstance()
    {
        if (instance == null)
        {
            instance = new CourierManager();
        }
        return instance;
    }

    private CourierManager()
    {

    }

    private OrderService orderService = new OrderServiceImpl();
    private CourierService courierService = new CourierServiceImpl();

    public void orderDelivery(Courier courier, Order order)
    {
        if (courier != null && order != null)
        {
            order.setCourier(courier);
            order.getCourier().setCourierStatus(CourierStatus.BUSY);
            order.setOrderStatus(OrderStatus.DELIVERY_PROCESS);

            orderService.createOrder(order);

            new Thread(() ->
            {
                try
                {
                    EmailManager.getInstance().sendMessage(order.getClient().getEmail(),
                            "Order delivery",
                            String.format("Your order number is %s. It will be delivered on %s at %s",
                                    order.getId(), order.getAddress(), order.getReceiveDate()));
                }
                catch (MessagingException e)
                {
                    e.printStackTrace();
                }
            });
        }
    }
    /**
     * Реализовать метод доставки заказа с параметрами "курьер", "заказ"
     * Курьер должен становиться занятым, заказ менять статус на DELIVERY_PROCESS,
     * клиент получать сообщение на почту с номером заказа, его статусом
     * и временем получения (delivery time)
     *
     * Реализовать метод "заказ доставлен",
     * где курьер становится свободным, а заказ закрытым
     *
     * Проверить метод на работоспособность
     */
}