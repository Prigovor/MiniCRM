package com.crm.menu.courier;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.main.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * Created by Bohdan on 26.02.2017.
 */
public class CourierMenuController
{
    public ListView<Order> listViewOrdersDelivering;
    public ListView<SelectedGood> listViewSelectedGoods;

    public Label labelClientName;

    public Button buttonOrderDelivered;
    public Button buttonRefresh;
    public Button buttonLogOut;

    private CourierMenuModel model = new CourierMenuModel();

    @FXML
    public void initialize()
    {
        refreshView();

        listViewOrdersDelivering.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue != null)
            {
                model.setSelectedOrder(newValue);
                listViewSelectedGoods.setItems(FXCollections.observableList(newValue.getGoods()));
                labelClientName.setText("Client: " + newValue.getClient().getName()
                        .concat(" ").concat(newValue.getClient().getSurname()
                                .concat(", Phone: ").concat(newValue.getClient().getPhone())));
            }
        });

        buttonOrderDelivered.setOnAction(event ->
        {
            model.closeOrder(model.getSelectedOrder());
            refreshView();
        });

        buttonRefresh.setOnAction(event ->
        {
            refreshView();
        });

        buttonLogOut.setOnAction(event ->
        {
            Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
        });
    }

    public void refreshView()
    {
        listViewOrdersDelivering.setItems(FXCollections.observableList(model.getListOrdersDelivering()));
        listViewSelectedGoods.getItems().clear();
        labelClientName.setText("");
    }
}
