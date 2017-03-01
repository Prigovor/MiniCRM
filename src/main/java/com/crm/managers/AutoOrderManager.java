package com.crm.managers;

import com.crm.database.entity.employee.courier.CourierStatus;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.service.FactoryService;
import com.crm.database.service.employee.courier.CourierService;

import javax.mail.MessagingException;
import java.io.IOException;

import static com.crm.database.manager.DatabaseManagerType.HIBERNATE;

/**
 * Created by Bohdan on 15.02.2017.
 */
public class AutoOrderManager
{
    private CourierService courierService = FactoryService.getCourierService(HIBERNATE);

    public void formOrder(String jsonFilePath) throws IOException, MessagingException
    {
        Order order = JsonFileManager.deserializeFromJsonFile(Order.class, jsonFilePath);

        if (order.getOrderStatus().equals(OrderStatus.PAID_UP))
        {
            CourierManager.getInstance()
                    .orderDelivery(courierService.getEntryByField("status", CourierStatus.FREE), order);
        }
        else
        {
            new Thread(() ->
            {
                EmailManager.getInstance()
                        .sendMessage(order.getClient().getEmail(), "Order", "Wait for free couriers");

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
