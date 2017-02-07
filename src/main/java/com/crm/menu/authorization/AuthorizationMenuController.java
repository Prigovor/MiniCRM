package com.crm.menu.authorization;

import com.crm.main.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Жека on 2/5/2017.
 */
public class AuthorizationMenuController
{
    public TextField tfLogin;
    public PasswordField pfPassword;

    private AuthorizationMenuModel model = new AuthorizationMenuModel();

    public void authorize()
    {
        boolean isAuthorized = false;
        try
        {
            isAuthorized = model.authorize(tfLogin.getText(), pfPassword.getText());

            if (!isAuthorized)
            {
                new Alert(Alert.AlertType.INFORMATION, "Incorrect login or password", ButtonType.OK).showAndWait();
            }
        }
        catch (IOException e)
        {
            new Alert(Alert.AlertType.INFORMATION, "Error while authorization", ButtonType.OK).showAndWait();
        }
    }

    public void createAccount()
    {
        try
        {
            model.createAccount();
        }
        catch (IOException e)
        {
            new Alert(Alert.AlertType.INFORMATION, "Error while creating account", ButtonType.OK).showAndWait();
        }
    }

    public void exit() throws Exception
    {
        Main.getInstance().stop();
    }
}
