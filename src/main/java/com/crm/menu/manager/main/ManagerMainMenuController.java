package com.crm.menu.manager.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Bohdan on 19.02.2017.
 */
public class ManagerMainMenuController
{
    public Button buttonLogOut;
    public Button buttonCreateOrder;

    private ManagerMainMenuModel model = new ManagerMainMenuModel();

    @FXML
    public void initialize()
    {
        buttonCreateOrder.setOnAction(event ->
        {
            model.addOrder();
        });

        buttonLogOut.setOnAction(event ->
        {
            model.logOut();
        });
    }
}
