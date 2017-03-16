package com.crm.menu.order_manager.order;

import com.crm.database.entity.order.Order;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class OrderManagementController
{
    @FXML
    private ListView<Order> listViewOrders;

    @FXML
    private Button buttonShowOrderInfo;

    @FXML
    private Button buttonDeleteOrder;

    @FXML
    private Button buttonChangeOrder;

    @FXML
    private Button buttonAddOrder;

    @FXML
    private Button buttonGenerateOrder;

    @FXML
    private Button buttonShowAllOrders;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonRefresh;

    @FXML
    private TableView tableView;

    @FXML
    private TextArea textAreaOrderInfo;

    private OrderManagementModel model = new OrderManagementModel();

    @FXML
    public void initialize()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getOrders()));

        listViewOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            model.setSelectedOrder(newValue);
        });

        buttonAddOrder.setOnAction(event ->
        {
            addOrder();
        });

        buttonChangeOrder.setOnAction(event ->
        {
            changeOrder();
        });

        buttonDeleteOrder.setOnAction(event ->
        {
            deleteOrder();
        });

        buttonShowOrderInfo.setOnAction(event ->
        {
            showOrderInfo();
        });

        buttonGenerateOrder.setOnAction(event ->
        {
            generateOrder();
        });

        buttonBack.setOnAction(event ->
        {
            back();
        });

        buttonRefresh.setOnAction(event ->
        {
            refresh();
        });

        buttonShowAllOrders.setOnAction(event ->
        {
            showAllOrders();
        });
    }

    public void showAllOrders()
    {
        textAreaOrderInfo.setOpacity(0.0);
        textAreaOrderInfo.setDisable(true);
        tableView.setOpacity(1.0);
        tableView.setDisable(false);

        tableView.setItems(FXCollections.observableList(model.getOrders()));

        tableView.getColumns().clear();
        for (Field field : Order.class.getDeclaredFields())
        {
            if (field.getName().equals("goods"))
            {
                continue;
            }
            TableColumn tableColumn = new TableColumn(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(tableColumn);
        }
    }

    public void addOrder()
    {
        model.addOrder();
    }

    public void showOrderInfo()
    {
        if (model.getSelectedOrder() != null)
        {
            tableView.setOpacity(0.0);
            tableView.setDisable(true);
            textAreaOrderInfo.setOpacity(1.0);
            textAreaOrderInfo.setDisable(false);

            textAreaOrderInfo.setText(model.getOrderInfo());
        }
        else
        {
            showInformationMessage("Select order in the list");
        }
    }

    public void changeOrder()
    {
        if (model.getSelectedOrder() != null)
        {
            model.changeOrder();
        }
        else
        {
            showInformationMessage("Select order in the list");
        }
    }

    public void deleteOrder()
    {
        if (model.getSelectedOrder() != null)
        {
            model.deleteOrder();
        }
        else
        {
            showInformationMessage("Select order in the list");
        }
    }

    public void generateOrder()
    {
        model.generateOrder();
    }

    public void back()
    {
        model.back();
    }

    public void refresh()
    {
        listViewOrders.setItems(FXCollections.observableList(model.getOrders()));
        tableView.getItems().clear();
    }

    private void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text).showAndWait();
    }
}
