package com.crm.menu.storekeeper.give_order;

import com.crm.entity.good.Good;
import com.crm.entity.good.selected_good.SelectedGood;
import com.crm.entity.order.Order;
import com.crm.entity.order.OrderStatus;
import com.crm.managers.CourierManager;
import com.crm.service.good.GoodService;
import com.crm.service.good.GoodServiceImpl;
import com.crm.service.order.OrderService;
import com.crm.service.order.OrderServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class StorekeeperGiveGoodsMenuModel
{
    private OrderService orderService = new OrderServiceImpl();
    private GoodService goodService = new GoodServiceImpl();

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
        List<Order> list = orderService.findAllEager();
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
                goodService.updateGood(goodInStore);
            }
        });

        CourierManager.getInstance().orderDelivery(selectedOrder.getCourier(), selectedOrder);
    }
}
