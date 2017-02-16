package com.crm.managers;

import com.crm.entity.client.Client;
import com.crm.entity.courier.Courier;
import com.crm.entity.courier.Status;
import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;

import javax.mail.MessagingException;

/**
 * Created by Bohdan on 15.02.2017.
 */
public class CourierManager {

    public void orderDelivery(Courier courier, Order order, Client client) {
        if (courier != null && order != null) {
            courier.setStatus(Status.BUSY);
            order.setOrderStatus(OrderStatus.DELIVERY_PROCESS);
            try {
                EmailManager.getInstance().sendMessage(client.getEmail(), "123", "Your order number: ");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
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