package com.crm.menu.admin;

import com.crm.main.Main;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class AdminMenuModel
{
    public void goToAccountManagement()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/account/account-management-menu.fxml");
    }

    public void goToEmployeeManagement()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/employee/employee-management-menu.fxml");
    }

    public void logOut()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
