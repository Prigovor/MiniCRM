package com.crm.menu.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Created by Жека on 2/5/2017.
 */
public class AdminMenuController {

    @FXML
    public ListView lvEmployee;
    @FXML public TableView tvTable;
    @FXML public TableColumn clnId;
    @FXML public TableColumn clnName;
    @FXML public TableColumn clnSurname;
    @FXML public TableColumn clnAge;
    @FXML public TableColumn clnGender;
    @FXML public TableColumn clnPosition;
    @FXML public Button btnCreate;
    @FXML public Button btnRemove;
    @FXML public Button btnChange;
    @FXML public Button btnGenerate;
    @FXML public Button btnExit;
    @FXML public Button btnShowAll;

    @FXML
    public void onActionButtonShowAll() {
    }

    @FXML
    public void onActionButtonCreate() {
    }

    @FXML
    public void onActionButtonRemove() {
    }

    @FXML
    public void onActionButtonChange() {
    }

    @FXML
    public void onActionButtonGenerate() {
    }

    @FXML
    public void onActionButtonExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

}
