package com.crm.menu.authorization;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Жека on 2/5/2017.
 */
public class AuthorizationMenuController
{
    public TextField tfLogin;
    public PasswordField pfPassword;

    private AuthorizationMenuModel model = new AuthorizationMenuModel();

    @FXML
    public Button btnOk;
    @FXML public Button btnExit;

    @FXML
    public void onActionButtonOk() throws IOException {
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

    @FXML
    public void onActionButtonExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

}
