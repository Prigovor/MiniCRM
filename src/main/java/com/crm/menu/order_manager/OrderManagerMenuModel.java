package com.crm.menu.order_manager;

import com.crm.main.Main;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class OrderManagerMenuModel
{
    public void goToOrderManagement()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/order-management-menu.fxml");
    }

    public void goToClientManagement()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/client/client-management-menu.fxml");
    }

    public void logOut()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
