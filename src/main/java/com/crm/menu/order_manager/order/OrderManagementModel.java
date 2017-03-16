package com.crm.menu.order_manager.order;

import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.create.OrderCreationModel;
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
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/create/input/client/client-choose-menu.fxml");
    }

    public void changeOrder()
    {
        Order order = FactoryService.getOrderService().getEntry(selectedOrder.getId(), orderEntry ->
        {
            Hibernate.initialize(orderEntry.getGoods());
        });

        OrderCreationModel.getInstance().setOrder(order);
        OrderCreationModel.getInstance().setListChosenGoods(order.getGoods());
        
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/create/input/client/client-choose-menu.fxml");
    }

    public void deleteOrder()
    {
        FactoryService.getOrderService().deleteEntry(selectedOrder.getId());
    }

    public void generateOrder()
    {

    }

    public String getOrderInfo()
    {
        return String.format("ID - %d\nClient - %s\nCourier - %s\nAddress - %s\nRegistration date - %s\n" +
                "Receive date - %s\nPrice - %f\nStatus - %s\n",
                selectedOrder.getId(), selectedOrder.getClient(), selectedOrder.getCourier(), selectedOrder.getAddress(),
                selectedOrder.getRegistrationDate(), selectedOrder.getReceiveDate(), selectedOrder.getOrderPrice(),
                selectedOrder.getOrderStatus());
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order-manager-main-menu.fxml");
    }
}
