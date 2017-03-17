package com.crm.menu.order_manager.order.create;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 15.02.2017.
 */
@Getter @Setter
public class OrderCreationModel
{
    private static OrderCreationModel instance;

    public static OrderCreationModel getInstance()
    {
        if (instance == null)
        {
            instance = new OrderCreationModel();
        }

        return instance;
    }

    private Order order = new Order();

    private List<SelectedGood> listChosenGoods = new ArrayList<>();
    private List<Good> listStoreGoods = FactoryService.getGoodService().getEntries().stream().filter(good ->
    {
        return !good.getClass().equals(SelectedGood.class);
    }).collect(Collectors.toList());

    public void setOrder(Order order)
    {
        this.order = order;

        if (order.getGoods() != null)
        {
            this.listChosenGoods = order.getGoods();
        }
    }

    public void saveOrder()
    {
        FactoryService.getOrderService().saveOrUpdate(order);

        Client client = FactoryService.getClientService().getEntry(order.getClient().getId(), clientEntry ->
        {
            Hibernate.initialize(clientEntry.getOrders());
        });

        Courier courier = FactoryService.getCourierService().getEntry(order.getCourier().getId(), courierEntry ->
        {
            Hibernate.initialize(courierEntry.getListOrders());
        });

        System.out.println(client.getOrders());
        System.out.println(courier.getListOrders());
    }

    public void clearData()
    {
        order = new Order();
        listChosenGoods = new ArrayList<>();
        listStoreGoods = FactoryService.getGoodService().getEntries().stream().filter(good ->
        {
            return !good.getClass().equals(SelectedGood.class);
        }).collect(Collectors.toList());
    }

    public void close()
    {
        clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/order-management-menu.fxml");
    }
}
