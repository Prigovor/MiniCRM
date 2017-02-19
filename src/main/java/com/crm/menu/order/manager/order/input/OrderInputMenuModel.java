package com.crm.menu.order.manager.order.input;

import com.crm.entity.courier.Courier;
import com.crm.main.Main;
import com.crm.managers.CourierManager;
import com.crm.menu.order.manager.OrderManagerMenuModel;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    private Courier courier = new Courier();

    public Courier getCourier()
    {
        return courier;
    }

    public void setCourier(Courier courier)
    {
        this.courier = courier;
    }

    public void confirm()
    {
        try
        {
            CourierManager.getInstance().orderDelivery(courier, OrderManagerMenuModel.getInstance().getOrder());
        }
        catch (MessagingException e)
        {

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
    }
}
