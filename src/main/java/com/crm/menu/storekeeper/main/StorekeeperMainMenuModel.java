package com.crm.menu.storekeeper.main;

import com.crm.entity.good.Good;
import com.crm.main.Main;
import com.crm.service.good.GoodService;
import com.crm.service.good.GoodServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 26.02.2017.
 */
public class StorekeeperMainMenuModel
{
    private GoodService goodService = new GoodServiceImpl();

    public List<Good> getListGoods()
    {
        return goodService.findAll().stream().filter(good ->
        {
            return good.getClass().equals(Good.class);
        }).collect(Collectors.toList());
    }

    public void openGiveGoodsMenu()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/storekeeper-give-goods-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }

    public void logOut()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }
}
