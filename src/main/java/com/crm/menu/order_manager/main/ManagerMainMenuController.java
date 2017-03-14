package com.crm.menu.order_manager.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Bohdan on 19.02.2017.
 */
public class ManagerMainMenuController
{
    public Button buttonLogOut;
    public Button buttonCreateOrder;
    public Button buttonOrderManagement;

    private ManagerMainMenuModel model = new ManagerMainMenuModel();

    @FXML
    public void initialize()
    {
        buttonOrderManagement.setOnAction(event ->
        {
            model.goToOrderManagement();
        });

        buttonCreateOrder.setOnAction(event ->
        {
            model.goToOrderCreation();
        });

        buttonLogOut.setOnAction(event ->
        {
            model.logOut();
        });
    }
}
