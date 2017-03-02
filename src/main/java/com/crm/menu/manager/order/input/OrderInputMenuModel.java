package com.crm.menu.manager.order.input;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.database.service.employee.courier.CourierService;
import com.crm.database.service.order.OrderService;
import com.crm.main.Main;
import com.crm.menu.manager.OrderManagerMenuModel;
import org.hibernate.Hibernate;

import java.util.Date;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    private OrderService orderService = FactoryService.getOrderService(DatabaseManagerType.HIBERNATE);
    private CourierService courierService = FactoryService.getCourierService(DatabaseManagerType.HIBERNATE);

    public void confirm(Courier courier)
    {
        order.setRegistrationDate(new Date());
        order.setReceiveDate(new Date());
        order.setOrderStatus(OrderStatus.READY);

        Courier courierEntry = courierService.getEntry(courier.getId(), courierWithOrders ->
        {
            Hibernate.initialize(courierWithOrders.getListOrders());
        });

        order.setCourier(courierEntry);
        courierEntry.getListOrders().add(order);

        orderService.saveEntry(order);
        courierService.updateEntry(courierEntry);

        OrderManagerMenuModel.getInstance().clearData();

        Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/good-choose-menu.fxml");
    }

    public void cancel()
    {
        OrderManagerMenuModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
    }
}
