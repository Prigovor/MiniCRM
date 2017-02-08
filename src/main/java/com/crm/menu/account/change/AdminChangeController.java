package com.crm.menu.account.change;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminChangeController {

    @FXML public Label lblId;
    @FXML public Label lblName;
    @FXML public Label lblSurname;
    @FXML public Label lblAge;
    @FXML public Label lblGender;
    @FXML public Label lblPosition;
    @FXML public TextField tfId;
    @FXML public TextField tfName;
    @FXML public TextField tfSurname;
    @FXML public TextField tfAge;
    @FXML public TextField tfGender;
    @FXML public TextField tfPosition;
    @FXML public Button btnCancel;
    @FXML public Button btnChange;


    @FXML
    public void onActionButtonChange() {
    }

    @FXML
    public void onActionButtonCancel() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }


}
