package com.crm.menu.order.manager.good.info;

import com.crm.entity.good.Good;
import com.crm.main.Main;

import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class GoodInfoMenuModel
{
    private static GoodInfoMenuModel instance;

    public static GoodInfoMenuModel getInstance()
    {
        if (instance == null)
        {
            instance = new GoodInfoMenuModel();
        }

        return instance;
    }

    private GoodInfoMenuModel()
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
        Main.getInstance().replaceSceneContent("/fxml-files/good-choose-menu.fxml");
    }
}
