package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import model.AuthorizationMenuModel;

import java.io.IOException;

/**
 * Created by Жека on 2/5/2017.
 */
public class AuthorizationMenuController
{
    public TextField tfLogin;
    public PasswordField pfPassword;

    private AuthorizationMenuModel model = new AuthorizationMenuModel();

    public void authorize() throws IOException
    {
        boolean authorizationResult = model.authorize(tfLogin.getText(), pfPassword.getText());
        if (authorizationResult)
        {
            Main.getInstance().replaceSceneContent("/view/admin_menu.fxml");
        }
        else
        {
            new Alert(Alert.AlertType.INFORMATION, "Enter valid data", ButtonType.OK).showAndWait();
        }
    }

    public void exit() throws Exception
    {
        Main.getInstance().stop();
    }
}
