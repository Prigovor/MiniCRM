package com.crm.menu.order_manager.order.create.input.good.info;

import com.crm.database.entity.good.Good;
import com.crm.main.Main;

import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class GoodInfoModel
{
    private static GoodInfoModel instance;

    public static GoodInfoModel getInstance()
    {
        if (instance == null)
        {
            instance = new GoodInfoModel();
        }

        return instance;
    }

    private GoodInfoModel()
    {

    }

    private Good good;

    public Good getGood()
    {
        return good;
    }

    public void setGood(Good good)
    {
        this.good = good;
    }

    public void backToGoodChoseMenu() throws IOException
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/good/good-choose-menu.fxml");
    }
}
