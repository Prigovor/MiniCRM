package com.crm.menu.storekeeper.give_goods;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.managers.CourierManager;
import com.crm.database.service.good.GoodService;
import com.crm.database.service.order.OrderService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class StorekeeperGiveGoodsMenuModel
{
    private OrderService orderService = FactoryService.getOrderService(DatabaseManagerType.HIBERNATE);
    private GoodService goodService = FactoryService.getGoodService(DatabaseManagerType.HIBERNATE);

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
        listSelectedGoods.forEach(selectedGood ->
        {
            List<Good> entries = goodService.getEntriesByField("nomination", selectedGood.getNomination())
                    .stream().filter(good ->
                    {
                        return good.getClass().equals(Good.class);
                    }).collect(Collectors.toList());

            Good goodInStore = entries.get(0);

            if (goodInStore != null)
            {
                goodInStore.setAmount(goodInStore.getAmount() - selectedGood.getAmount());
                goodService.updateEntry(goodInStore);
            }
        });

        CourierManager.getInstance().orderDelivery(selectedOrder.getCourier(), selectedOrder);
    }
}
