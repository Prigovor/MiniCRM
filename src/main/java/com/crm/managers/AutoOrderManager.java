package com.crm.managers;

import com.crm.entity.courier.CourierStatus;
import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;
import com.crm.service.courier.CourierService;
import com.crm.service.courier.CourierServiceImpl;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Bohdan on 15.02.2017.
 */
public class AutoOrderManager
{
    private CourierService courierService = new CourierServiceImpl();

    public void formOrder(String jsonFilePath) throws IOException, MessagingException
    {
        Order order = JsonFileManager.deserializeFromJsonFile(Order.class, jsonFilePath);

        if (order.getOrderStatus().equals(OrderStatus.PAID_UP))
        {
            CourierManager.getInstance()
                    .orderDelivery(courierService.getEntryByField("status", CourierStatus.FREE), order);

            new Thread(() ->
            {
                try
                {
                    EmailManager.getInstance()
                            .sendMessage(order.getClient().getEmail(), "Order", "Order is delivering");
                }
                catch (MessagingException e)
                {

                }
            }).start();
        }
        else
        {
            new Thread(() ->
            {
                try
                {
                    EmailManager.getInstance()
                            .sendMessage(order.getClient().getEmail(), "Order", "Wait for free couriers");
                }
                catch (MessagingException e)
                {

                }
            }).start();
        }
    }

    /**
     * Реализовать метод "сформировать заказ", куда передается файлик json заказа,
     * если полученый заказ оплачен (PAID_UP), то вызываем метод доставки заказа из
     * CourierManager, предварительно выбрав из базы свободного курьера,
     * если нет - то сообщение на почту о том,
     * что заказ c таким-то номером оформлен (READY), адрес где оплатить
     * наличкой и номер счета/карточки куда можно оплатить банковской картой
     *
     * Проверить метод на работоспособность
     */
}
