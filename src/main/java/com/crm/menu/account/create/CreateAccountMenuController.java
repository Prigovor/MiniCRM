package com.crm.menu.account.create;

import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuController
{
    private CreateAccountMenuModel model = new CreateAccountMenuModel();

    @FXML
    public Label lblId;
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
    @FXML public Button btnAdd;
    @FXML public Button btnCancel;

    @FXML
    public void onActionButtonAdd() {
        User user = model.getUser();
        Employee employee = model.getEmployee();

        try
        {
            model.createAccount();
        }
        catch (CreateAccountException e)
        {

        }
        catch (IOException e)
        {

        }
    }

    @FXML
    public void onActionButtonCancel() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
