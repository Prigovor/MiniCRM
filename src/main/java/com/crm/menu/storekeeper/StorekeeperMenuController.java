package com.crm.menu.storekeeper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Bohdan on 13.03.2017.
 */
public class StorekeeperMenuController
{
    public Button buttonStoreManagement;
    public Button buttonGoodsDelivery;
    public Button buttonLogOut;

    private StorekeeperMenuModel model = new StorekeeperMenuModel();

    @FXML
    public void initialize()
    {
        buttonStoreManagement.setOnAction(event ->
        {
            model.goToStoreManagement();
        });

        buttonGoodsDelivery.setOnAction(event ->
        {
            model.goToGoodsDelivery();
        });

        buttonLogOut.setOnAction(event ->
        {
            model.logOut();
        });
    }
}
