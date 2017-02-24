package com.crm.menu.storekeeper;

import com.crm.entity.good.SelectedGood;
import com.crm.entity.order.Order;
import com.crm.main.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class StorekeeperMenuController
{
    public ListView<Order> listViewOrders;
    public ListView<SelectedGood> listViewOrderGoods;

    public Label labelCourierName;

    public Button buttonGiveGoods;
    public Button buttonLogOut;

    private StorekeeperMenuModel model = new StorekeeperMenuModel();

    @FXML
    public void initialize()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getListOrders()));

        listViewOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            labelCourierName.setText(newValue.getCourier().getName() + " " + newValue.getCourier().getSurname());
            listViewOrderGoods.setItems(FXCollections.observableList(newValue.getGoods()));
        });

        buttonGiveGoods.setOnAction(event ->
        {

        });

        buttonLogOut.setOnAction(event ->
        {
            try
            {
                Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
            }
            catch (IOException e)
            {

            }
        });
    }
}
