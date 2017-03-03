package com.crm.menu.authorization;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 23.02.2017.
 */
public class AuthorizationMenuController
{
    public Button buttonLogIn;
    public Button buttonRemindPassword;
    public Button buttonExit;

    public TextField textFieldLogin;
    public TextField textFieldPassword;

    private AuthorizationMenuModel model = new AuthorizationMenuModel();

    @FXML
    public void initialize()
    {
        buttonLogIn.setOnAction(event ->
        {
            try
            {
                model.authorize(textFieldLogin.getText(), textFieldPassword.getText());
            }
            catch (RuntimeException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonRemindPassword.setOnAction(event ->
        {
            try
            {
                model.remindPassword();
            }
            catch (RuntimeException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonExit.setOnAction(event ->
        {
            model.exit();
        });
    }

    private void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
