package com.crm.menu.order_manager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class OrderManagerMenuController
{
    public Button buttonLogOut;
    public Button buttonOrderManagement;
    public Button buttonClientManagement;

    private OrderManagerMenuModel model = new OrderManagerMenuModel();

    @FXML
    public void initialize()
    {
        buttonOrderManagement.setOnAction(event ->
        {
            model.goToOrderManagement();
        });

        buttonClientManagement.setOnAction(event ->
        {
            model.goToClientManagement();
        });

        buttonLogOut.setOnAction(event ->
        {
            model.logOut();
        });
    }
}
