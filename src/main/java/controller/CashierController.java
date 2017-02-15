package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CashierController {

    @FXML public TableView tvOrder_Status;
    @FXML public TableColumn clnOrderNumber;
    @FXML public TableColumn clnStatus;
    @FXML public TextArea taOrderNumber;
    @FXML public ComboBox comboBoxStatus;
    @FXML public TextArea taCustomer;
    @FXML public Label lblAddress;
    @FXML public TextArea taAddress;
    @FXML public TextArea taManage;

    @FXML public TableView tvOrderDetails;
    @FXML public TableColumn clnNumber;
    @FXML public DatePicker datePicker;
    @FXML public TableColumn clnProduct;
    @FXML public TableColumn clnCount;
    @FXML public TableColumn clnCost;
    @FXML public TableColumn clnTotalCost;

    @FXML public TextArea taToPay;
    @FXML public Button btnOk;
    @FXML public Label lblManager;
    @FXML public Label lblDate;
    @FXML public Label lblToPay;

    @FXML
    public void onActionComboBoxStatus() {

    }

    @FXML
    public void onActionButtonOk() {
    }
}

