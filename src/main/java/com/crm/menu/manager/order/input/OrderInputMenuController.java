package com.crm.menu.manager.order.input;

import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.employee.courier.CourierStatus;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.database.service.courier.CourierService;
import com.crm.menu.manager.OrderManagerMenuModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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

    private OrderInputMenuModel model = new OrderInputMenuModel();

    private CourierService courierService = FactoryService.getCourierService(DatabaseManagerType.HIBERNATE);

    @FXML
    public void initialize()
    {
        choiceBoxCouriers.setItems(FXCollections.observableList(
                courierService.getEntriesByField("courierStatus", CourierStatus.FREE)));

        choiceBoxCouriers.setValue(OrderManagerMenuModel.getInstance().getOrder().getCourier());

        textFieldAddress.setText(OrderManagerMenuModel.getInstance().getOrder().getAddress());

        buttonConfirm.setOnAction(event ->
        {
            OrderManagerMenuModel.getInstance().getOrder().setAddress(
                    textFieldAddress.getText());

            Courier courier = (Courier) choiceBoxCouriers.getSelectionModel().getSelectedItem();

            model.confirm(courier);
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
}
