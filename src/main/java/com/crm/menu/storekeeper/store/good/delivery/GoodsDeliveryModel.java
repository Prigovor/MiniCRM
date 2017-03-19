package com.crm.menu.storekeeper.store.good.delivery;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.service.FactoryService;
import com.crm.database.service.good.GoodService;
import com.crm.database.service.order.OrderService;
import com.crm.main.Main;
import com.crm.managers.CourierManager;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class GoodsDeliveryModel
{
    private OrderService orderService = FactoryService.getOrderService();
    private GoodService goodService = FactoryService.getGoodService();

    private Order selectedOrder;

    public Order getSelectedOrder()
    {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder)
    {
        this.selectedOrder = selectedOrder;
    }

    public List<Order> getListReadyOrders()
    {
        List<Order> list = orderService.getEntries();
        return list.stream().filter(order ->
        {
            return order.getOrderStatus().equals(OrderStatus.READY);
        }).collect(Collectors.toList());
    }

    public void giveGoodsToCourier(List<SelectedGood> listSelectedGoods)
    {
        CourierManager.getInstance().orderDelivery(selectedOrder.getCourier(), selectedOrder);
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/storekeeper-menu.fxml");
    }
}
