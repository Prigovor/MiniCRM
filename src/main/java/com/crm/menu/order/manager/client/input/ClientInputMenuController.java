package com.crm.menu.order.manager.client.input;

import com.crm.main.Main;
import com.crm.menu.View;
import com.crm.service.UserExistsException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import javax.mail.MessagingException;
import java.io.IOException;

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
