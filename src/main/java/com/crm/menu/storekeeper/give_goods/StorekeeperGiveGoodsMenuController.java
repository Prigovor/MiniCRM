package com.crm.menu.storekeeper.give_goods;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.hibernate.Hibernate;

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

                Order order = FactoryService.getOrderService().getEntry(newValue.getId(), orderEntry ->
                {
                    Hibernate.initialize(orderEntry.getGoods());
                });

                listViewOrderGoods.setItems(FXCollections.observableList(order.getGoods()));
            }
        });

        buttonGiveGoods.setOnAction(event ->
        {
            if (model.getSelectedOrder() != null)
            {
                model.giveGoodsToCourier(listViewOrderGoods.getItems());
                refreshView();
            }
            else
            {
                new Alert(Alert.AlertType.INFORMATION, "Select order first").showAndWait();
            }
        });

        buttonRefresh.setOnAction(event ->
        {
            refreshView();
        });

        buttonCancel.setOnAction(event ->
        {
            Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/main/storekeeper-main-menu.fxml");
        });
    }

    public void refreshView()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getListReadyOrders()));
        listViewOrderGoods.getItems().clear();
        labelCourierName.setText("");
    }
}
