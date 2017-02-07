package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import start.Initial;

import java.io.IOException;

public class AuthorizationMenuController implements ControlledScreen {

    ScreensController screensController;

    @FXML
    public Button btnOk;
    @FXML
    public Button btnExit;

    @FXML
    public void onActionButtonOk() throws IOException {

        screensController.setScreen(Initial.ADMIN_SCREEN);

//        Stage stage = (Stage) btnOk.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("/view/admin_menu.fxml"));
//
//        stage.setTitle("Admin");
//        stage.setResizable(false);
//        stage.setScene(new Scene(root));
//        stage.show();
    }

    @FXML
    public void onActionButtonExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        screensController = screenParent;
    }
}
