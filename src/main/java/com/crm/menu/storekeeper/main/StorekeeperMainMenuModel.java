package com.crm.menu.storekeeper.main;

import com.crm.database.entity.good.Good;
import com.crm.database.service.FactoryService;
import com.crm.database.service.good.GoodService;
import com.crm.main.Main;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 26.02.2017.
 */
public class StorekeeperMainMenuModel
{
    private GoodService goodService = FactoryService.getGoodService();

    public List<Good> getListGoods()
    {
        return goodService.getEntries().stream().filter(good ->
        {
            return good.getClass().equals(Good.class);
        }).collect(Collectors.toList());
    }

    public void openGiveGoodsMenu()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/give_goods/storekeeper-give-goods-menu.fxml");
    }

    public void logOut()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
