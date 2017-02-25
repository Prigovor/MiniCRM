package com.crm.menu.storekeeper;

import com.crm.entity.selected_good.SelectedGood;
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
    public Button buttonRefresh;

    private StorekeeperMenuModel model = new StorekeeperMenuModel();

    @FXML
    public void initialize()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getListReadyOrders()));

        listViewOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue != null)
            {
                model.setSelectedOrder(newValue);

                labelCourierName.setText(newValue.getCourier().getName() + " " + newValue.getCourier().getSurname());
                listViewOrderGoods.setItems(FXCollections.observableList(newValue.getGoods()));
            }
        });

        buttonGiveGoods.setOnAction(event ->
        {
            model.giveGoodsToCourier(listViewOrderGoods.getItems());
            refreshView();
        });

        buttonRefresh.setOnAction(event ->
        {
            refreshView();
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

    public void refreshView()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getListReadyOrders()));
        listViewOrderGoods.getItems().clear();
    }
}
