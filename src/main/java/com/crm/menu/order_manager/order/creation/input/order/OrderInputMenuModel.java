package com.crm.menu.order_manager.order.creation.input.order;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.service.FactoryService;
import com.crm.database.service.employee.courier.CourierService;
import com.crm.database.service.order.OrderService;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.creation.OrderCreationModel;
import org.hibernate.Hibernate;

import java.util.Date;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Order order = OrderCreationModel.getInstance().getOrder();

    private OrderService orderService = FactoryService.getOrderService();
    private CourierService courierService = FactoryService.getCourierService();

    public void confirm(Courier courier)
    {
        order.setRegistrationDate(new Date());
        order.setOrderStatus(OrderStatus.READY);

        Courier courierEntry = courierService.getEntry(courier.getId(), courierWithOrders ->
        {
            Hibernate.initialize(courierWithOrders.getListOrders());
        });

        order.setCourier(courierEntry);
        courierEntry.getListOrders().add(order);

        orderService.saveOrUpdate(order);
        courierService.updateEntry(courierEntry);

        OrderCreationModel.getInstance().clearData();

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/main/order-manager-main-menu.fxml");
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/good/good-choose-menu.fxml");
    }

    public void cancel()
    {
        OrderCreationModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/main/order-manager-main-menu.fxml");
    }
}
