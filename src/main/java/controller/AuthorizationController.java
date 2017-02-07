package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {

    @FXML public Button btnOk;
    @FXML public Button btnExit;

    @FXML
    public void onActionButtonOk() throws IOException{
        Stage stage = (Stage) btnOk.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/admin_menu.fxml"));

        stage.setTitle("Admin");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void onActionButtonExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
