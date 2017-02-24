package com.crm.menu.manager.order.input;

import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;
import com.crm.main.Main;
import com.crm.managers.JsonFileManager;
import com.crm.menu.manager.OrderManagerMenuModel;
import com.crm.service.AccountExistsException;
import com.crm.service.client.ClientService;
import com.crm.service.client.ClientServiceImpl;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;
import org.hibernate.Hibernate;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    private OrderService orderService = new OrderServiceImpl();

    public void confirm()
    {
        try
        {
            order.setRegistrationDate(new Date());
            order.setReceiveDate(new Date());
            order.setOrderStatus(OrderStatus.READY);

            orderService.createOrder(order);

            JsonFileManager.serializeToJsonFile(order,
                    "json-files/order-" +
                            order.getClient().getSurname().toLowerCase() + ".json");

            OrderManagerMenuModel.getInstance().clearData();

            Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }

    public void back()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/good-choose-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }

    public void cancel()
    {
        OrderManagerMenuModel.getInstance().clearData();
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }
}
