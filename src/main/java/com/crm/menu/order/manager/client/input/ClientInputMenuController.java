package com.crm.menu.order.manager.client.input;

import com.crm.service.UserExistsException;
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
        textFieldName.setText(model.getClient().getName());
        textFieldSurname.setText(model.getClient().getSurname());
        textFieldEmail.setText(model.getClient().getEmail());
        textFieldPhone.setText(model.getClient().getPhone());
    }

    public void confirm()
    {
        if (textFieldName.getText().isEmpty() || textFieldSurname.getText().isEmpty()
                || textFieldEmail.getText().isEmpty() || textFieldPhone.getText().isEmpty())
        {
            new Alert(Alert.AlertType.INFORMATION, "Fill all text fields", ButtonType.OK);
        }
        else
        {
            try
            {
                model.confirm(textFieldName.getText(), textFieldSurname.getText(), textFieldEmail.getText(), textFieldPhone.getText());
            }
            catch (UserExistsException | MessagingException e)
            {
                new Alert(Alert.AlertType.INFORMATION, e.getMessage(), ButtonType.OK);
            }
        }
    }

    public void back()
    {
        model.back();
    }
}
