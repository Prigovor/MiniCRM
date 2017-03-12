package com.crm.managers;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.service.FactoryService;
import com.crm.database.service.employee.courier.CourierService;
import com.crm.database.service.order.OrderService;
import org.hibernate.Hibernate;

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

    private OrderService orderService = FactoryService.getOrderService();
    private CourierService courierService = FactoryService.getCourierService();

    public void orderDelivery(Courier courier, Order order)
    {
        if (courier != null && order != null)
        {
            Courier courierEntry = courierService.getEntry(courier.getId(), courierWithOrders ->
            {
                Hibernate.initialize(courierWithOrders.getListOrders());
            });

            order.setOrderStatus(OrderStatus.DELIVERY_PROCESS);

            orderService.updateEntry(order);
            courierService.updateEntry(courierEntry);

            new Thread(() ->
            {
                EmailManager.getInstance().sendMessage(order.getClient().getEmail(),
                        "Order delivery",
                        String.format("Your order number is %s. It will be delivered on %s at %s",
                                order.getId(), order.getAddress(), order.getReceiveDate()));

            }).start();


            new Thread(() ->
            {
                EmailManager.getInstance().sendMessage(order.getCourier().getEmail(),
                        "Order delivery",
                        String.format("Your order number is %s. You should deliver it on %s at %s",
                                order.getId(), order.getAddress(), order.getReceiveDate()));
            }).start();
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