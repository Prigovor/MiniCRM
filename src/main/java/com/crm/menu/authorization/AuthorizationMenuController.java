package com.crm.menu.authorization;

import com.crm.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;

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
                switch (model.authorize(textFieldLogin.getText(), textFieldPassword.getText()))
                {
                    case LOCKED:
                    {
                        showInformationMessage("Account is locked");
                        break;
                    }
                    case INCORRECT_LOGIN_PASSWORD:
                    {
                        showInformationMessage("Incorrect login or password");
                        break;
                    }
                    case SUCCESSFUL:
                    {
                        return;
                    }
                }
            }
            catch (IOException e)
            {

            }
        });

        buttonRemindPassword.setOnAction(event ->
        {
            try
            {
                model.remindPassword();
            }
            catch (AccountExistsException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonExit.setOnAction(event ->
        {
            Main.getInstance().exit();
        });
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
