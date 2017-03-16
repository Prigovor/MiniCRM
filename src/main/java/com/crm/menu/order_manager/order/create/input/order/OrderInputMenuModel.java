package com.crm.menu.order_manager.order.create.input.order;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.create.OrderCreationModel;

import java.util.Date;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Order order = OrderCreationModel.getInstance().getOrder();

    public void setOrderData(Courier courier, Date receiveDate, String address)
    {
        order.setRegistrationDate(new Date());
        order.setOrderStatus(OrderStatus.READY);
        order.setCourier(courier);
        order.setReceiveDate(receiveDate);
        order.setAddress(address);
    }

    public void confirm()
    {
        OrderCreationModel.getInstance().saveOrder();

        OrderCreationModel.getInstance().close();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/good/good-choose-menu.fxml");
    }

    public void cancel()
    {
        OrderCreationModel.getInstance().close();
    }
}
