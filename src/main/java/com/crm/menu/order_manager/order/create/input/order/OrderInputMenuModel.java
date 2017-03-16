package com.crm.menu.order_manager.order.create.input.order;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.create.OrderCreationModel;

import java.util.Date;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Order order = OrderCreationModel.getInstance().getOrder();

    public void confirm(Courier courier)
    {
        order.setRegistrationDate(new Date());

        order.setCourier(courier);

        OrderCreationModel.getInstance().saveOrder();

        OrderCreationModel.getInstance().clearData();

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/order-management-menu.fxml");
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/good/good-choose-menu.fxml");
    }

    public void cancel()
    {
        OrderCreationModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order-manager-main-menu.fxml");
    }
}
