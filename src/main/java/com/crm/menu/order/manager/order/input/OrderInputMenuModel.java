package com.crm.menu.order.manager.order.input;

import com.crm.main.Main;
import com.crm.menu.order.manager.OrderManagerMenuModel;

import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class OrderInputMenuModel
{
    public void confirm()
    {

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
