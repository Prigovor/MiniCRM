package com.crm.menu.order_manager.order.creation;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    public void clearData()
    {
        instance = new OrderCreationModel();
    }

    private Order order = new Order();
    private Client client = new Client();
    private Courier courier = new Courier();
    private Employee employee = new Employee();

    private List<SelectedGood> listChosenGoods = new ArrayList<>();
    private List<Good> listStoreGoods = FactoryService.getGoodService().getEntries();
}
