package com.crm.menu.manager.order.input;

import com.crm.dao.FactoryDAO;
import com.crm.entity.courier.Courier;
import com.crm.entity.courier.CourierStatus;
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

    @FXML
    public void initialize()
    {
        choiceBoxCouriers.setItems(FXCollections.observableList(
                FactoryDAO.getCourierDAO().getEntriesByField("courierStatus", CourierStatus.FREE)));

        choiceBoxCouriers.setValue(OrderManagerMenuModel.getInstance().getOrder().getCourier());

        textFieldAddress.setText(OrderManagerMenuModel.getInstance().getOrder().getAddress());

        buttonConfirm.setOnAction(event ->
        {
            OrderManagerMenuModel.getInstance().getOrder().setAddress(
                    textFieldAddress.getText());
            OrderManagerMenuModel.getInstance().getOrder().setCourier(
                    (Courier) choiceBoxCouriers.getSelectionModel().getSelectedItem());

            model.confirm();
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
