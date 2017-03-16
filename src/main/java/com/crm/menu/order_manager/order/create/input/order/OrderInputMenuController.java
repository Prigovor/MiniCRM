package com.crm.menu.order_manager.order.create.input.order;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.employee.courier.CourierStatus;
import com.crm.database.entity.order.Order;
import com.crm.database.service.FactoryService;
import com.crm.database.service.employee.courier.CourierService;
import com.crm.database.validation.ValidationException;
import com.crm.menu.order_manager.order.create.OrderCreationModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Bohdan on 18.02.2017.
 */
public class OrderInputMenuController
{
    public Button buttonConfirm;
    public Button buttonBack;
    public Button buttonCancel;

    public TextField textFieldAddress;
    public ChoiceBox choiceBoxCouriers;

    public DatePicker datePickerReceiveDate;

    private OrderInputMenuModel model = new OrderInputMenuModel();

    private CourierService courierService = FactoryService.getCourierService();

    private Order order = OrderCreationModel.getInstance().getOrder();

    @FXML
    public void initialize()
    {
        choiceBoxCouriers.setItems(FXCollections.observableList(
                courierService.getEntriesByField("courierStatus", CourierStatus.FREE)));

        choiceBoxCouriers.setValue(OrderCreationModel.getInstance().getOrder().getCourier());

        textFieldAddress.setText(OrderCreationModel.getInstance().getOrder().getAddress());

        if (order.getReceiveDate() != null)
        {
            datePickerReceiveDate.setValue(new java.sql.Date(order.getReceiveDate().getTime()).toLocalDate());
        }

        buttonConfirm.setOnAction(event ->
        {
            if (datePickerReceiveDate.getValue() == null)
            {
                showInformationMessage("Set receive date, please");
                return;
            }

            try
            {
                Courier courier = (Courier) choiceBoxCouriers.getSelectionModel().getSelectedItem();
                Date receiveDate = Date.from(datePickerReceiveDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                String address = textFieldAddress.getText();

                model.setOrderData(courier, receiveDate, address);

                model.confirm();
            }
            catch (ValidationException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonBack.setOnAction(event ->
        {
            model.back();
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }

    private void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text).showAndWait();
    }
}
