package com.crm.menu.order.manager.order.input;

import com.crm.entity.order.Order;
import com.crm.main.Main;
import com.crm.managers.CourierManager;
import com.crm.managers.JsonFileManager;
import com.crm.menu.order.manager.OrderManagerMenuModel;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    public void confirm()
    {
        try
        {
            order.setClient(OrderManagerMenuModel.getInstance().getClient());

            order.setRegistrationDate(new Date());
            order.setReceiveDate(new Date());

            CourierManager.getInstance().orderDelivery(order.getCourier(), order);

            JsonFileManager.serializeToJsonFile(order,
                    "D:\\Bohdan\\IdeaProjects\\MiniCRM\\src\\main\\resources\\json-files\\order-" +
                    order.getClient().getSurname().toLowerCase() + ".json");

            Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void back()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/good-choose-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }

    public void cancel()
    {
        OrderManagerMenuModel.getInstance().clearData();
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }
}
