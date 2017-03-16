package com.crm.menu.order_manager.client.create.data;

import com.crm.database.entity.client.Client;
import com.crm.database.validation.ValidationException;
import com.crm.menu.order_manager.client.create.ClientCreationModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class ClientDataController
{
    public TextField textFieldName;
    public TextField textFieldSurname;
    public TextField textFieldEmail;
    public TextField textFieldPhone;

    public Button buttonConfirm;
    public Button buttonCancel;

    private ClientDataModel model = new ClientDataModel();

    @FXML
    public void initialize()
    {
        Client client = ClientCreationModel.getInstance().getClient();

        textFieldName.setText(client.getName());
        textFieldSurname.setText(client.getSurname());
        textFieldEmail.setText(client.getEmail());
        textFieldPhone.setText(client.getPhone());

        buttonConfirm.setOnAction(event ->
        {
            confirm();
        });

        buttonCancel.setOnAction(event ->
        {
            ClientCreationModel.getInstance().close();
        });
    }

    private void confirm()
    {
        model.setClientData(textFieldName.getText(), textFieldSurname.getText(),
                textFieldEmail.getText(), textFieldPhone.getText());

        try
        {
            model.confirm();
        }
        catch (ValidationException e)
        {
            showInformationMessage(e.getMessage());
        }
    }

    private void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text).showAndWait();
    }
}
