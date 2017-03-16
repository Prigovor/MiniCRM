package com.crm.menu.order_manager.order.management;

import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.creation.OrderCreationModel;
import com.crm.menu.order_manager.order.info.OrderInfoModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Created by Bohdan on 14.03.2017.
 */
@Getter
@Setter
public class OrderManagementModel
{
    private Order selectedOrder;

    public List<Order> getOrders()
    {
        return FactoryService.getOrderService().getEntries();
    }

    public void addOrder()
    {
        OrderCreationModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/client/client-input-menu.fxml");
    }

    public void changeOrder()
    {
        FactoryService.getOrderService().getEntry(selectedOrder.getId(), order ->
        {
            Hibernate.initialize(order.getGoods());

            OrderCreationModel.getInstance().setOrder(order);
            OrderCreationModel.getInstance().setClient(order.getClient());
            OrderCreationModel.getInstance().setCourier(order.getCourier());
            OrderCreationModel.getInstance().setListChosenGoods(order.getGoods());
        });

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/client/client-input-menu.fxml");
    }

    public void deleteOrder()
    {
        FactoryService.getOrderService().deleteEntry(selectedOrder.getId());
    }

    public void generateOrder()
    {

    }

    public void showOrderInfo()
    {
        FactoryService.getOrderService().getEntry(selectedOrder.getId(), order ->
        {
            Hibernate.initialize(order.getGoods());

            OrderInfoModel.getInstance().setOrder(order);
        });

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/info/order-info-menu.fxml");
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/main/order-manager-main-menu.fxml");
    }
}
