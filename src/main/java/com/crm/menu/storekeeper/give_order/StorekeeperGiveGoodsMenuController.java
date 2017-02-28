package com.crm.menu.storekeeper.give_order;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.main.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class StorekeeperGiveGoodsMenuController
{
    public ListView<Order> listViewOrders;
    public ListView<SelectedGood> listViewOrderGoods;

    public Label labelCourierName;

    public Button buttonGiveGoods;
    public Button buttonCancel;
    public Button buttonRefresh;

    private StorekeeperGiveGoodsMenuModel model = new StorekeeperGiveGoodsMenuModel();

    @FXML
    public void initialize()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getListReadyOrders()));

        listViewOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue != null)
            {
                model.setSelectedOrder(newValue);

                labelCourierName.setText("Courier: " + newValue.getCourier().getName()
                        .concat(" ").concat(newValue.getCourier().getSurname())
                        .concat(", Phone: ").concat(newValue.getCourier().getPhone()));

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

        buttonCancel.setOnAction(event ->
        {
            Main.getInstance().replaceSceneContent("/fxml-files/storekeeper-main-menu.fxml");
        });
    }

    public void refreshView()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getListReadyOrders()));
        listViewOrderGoods.getItems().clear();
        labelCourierName.setText("");
    }
}
