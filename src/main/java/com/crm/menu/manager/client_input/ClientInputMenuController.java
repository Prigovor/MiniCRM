package com.crm.menu.manager.client_input;

import com.crm.menu.manager.OrderManagerMenuModel;
import com.crm.service.AccountExistsException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import javax.mail.MessagingException;

/**
 * Created by Bohdan on 17.02.2017.
 */
public class ClientInputMenuController
{
    public TextField textFieldName;
    public TextField textFieldSurname;
    public TextField textFieldEmail;
    public TextField textFieldPhone;

    public Button buttonBack;
    public Button buttonConfirm;

    private ClientInputMenuModel model = new ClientInputMenuModel();

    @FXML
    public void initialize()
    {
        textFieldName.setText(
                OrderManagerMenuModel.getInstance().getClient().getName());
        textFieldSurname.setText(
                OrderManagerMenuModel.getInstance().getClient().getSurname());
        textFieldEmail.setText(
                OrderManagerMenuModel.getInstance().getClient().getEmail());
        textFieldPhone.setText(
                OrderManagerMenuModel.getInstance().getClient().getPhone());
    }

    public void confirm()
    {
        try
        {
            model.confirm(textFieldName.getText(), textFieldSurname.getText(), textFieldEmail.getText(), textFieldPhone.getText());
        }
        catch (AccountExistsException | MessagingException e)
        {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage(), ButtonType.OK).showAndWait();
        }
    }

    public void back()
    {
        model.back();
    }
}
