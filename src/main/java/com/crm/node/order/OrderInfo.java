package com.crm.node.order;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class OrderInfo extends AnchorPane
{
    public TextField textFieldId;
    public TextField textFieldClient;
    public TextField textFieldAddress;
    public TextField textFieldCourier;

    public DatePicker datePickerRegistrationDate;
    public DatePicker datePickerReceiveDate;

    public ChoiceBox<OrderStatus> choiceBoxStatus;

    public TextField textFieldPrice;

    public ListView<SelectedGood> listViewSelectedGoods;

    private Order order;

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;

        textFieldId.setText(String.valueOf(order.getId()));
        textFieldClient.setText(String.valueOf(order.getClient()));
        textFieldAddress.setText(order.getAddress());
        textFieldCourier.setText(String.valueOf(order.getCourier()));

        datePickerRegistrationDate.setValue(new java.sql.Date(order.getRegistrationDate().getTime()).toLocalDate());
        datePickerReceiveDate.setValue(new java.sql.Date(order.getReceiveDate().getTime()).toLocalDate());

        choiceBoxStatus.setValue(order.getOrderStatus());
        textFieldPrice.setText(String.valueOf(order.getOrderPrice()));

        listViewSelectedGoods.setItems(FXCollections.observableList(order.getGoods()));
    }

    public OrderInfo()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml-files/custom-panes/order-info.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void clear()
    {
        textFieldId.clear();
        textFieldClient.clear();
        textFieldAddress.clear();
        textFieldCourier.clear();

        datePickerReceiveDate.setValue(null);
        datePickerRegistrationDate.setValue(null);

        choiceBoxStatus.setValue(null);

        textFieldPrice.clear();

        listViewSelectedGoods.getItems().clear();
    }
}
