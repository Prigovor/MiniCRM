package com.crm.menu.manager.order.input;

import com.crm.dao.FactoryDAO;
import com.crm.entity.courier.Courier;
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

    public void confirm(Courier courier)
    {
        try
        {
            order.setRegistrationDate(new Date());
            order.setReceiveDate(new Date());
            order.setOrderStatus(OrderStatus.READY);

            Courier courierEntry = FactoryDAO.getCourierDAO().readCourierEager(courier.getId());

            order.setCourier(courierEntry);
            courierEntry.getListOrders().add(order);

            orderService.createOrder(order);
            FactoryDAO.getCourierDAO().updateCourier(courierEntry);

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
