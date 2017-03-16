package com.crm.menu.storekeeper;

import com.crm.main.Main;

/**
 * Created by Bohdan on 13.03.2017.
 */
public class StorekeeperMenuModel
{
    public void goToStoreManagement()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/store-management-menu.fxml");
    }

    public void goToGoodsDelivery()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/good/delivery/goods-delivery-menu.fxml");
    }

    public void logOut()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
