package com.crm.menu.order_manager.order.info;

import com.crm.database.entity.order.Order;
import com.crm.main.Main;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 14.03.2017.
 */
@Getter @Setter
public class OrderInfoModel
{
    private static final OrderInfoModel instance = new OrderInfoModel();

    public static OrderInfoModel getInstance()
    {
        return instance;
    }

    private OrderInfoModel()
    {

    }

    private Order order = new Order();

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/management/order-management-menu.fxml");
    }
}
