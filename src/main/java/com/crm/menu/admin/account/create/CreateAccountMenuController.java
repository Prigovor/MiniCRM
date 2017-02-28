package com.crm.menu.admin.account.create;

import com.crm.main.Main;
import com.crm.node_custom.account_info.AccountInfo;
import com.crm.node_custom.employee_info.EmployeeInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * Created by Bohdan on 22.02.2017.
 */
public class CreateAccountMenuController
{
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonGeneratePassword;

    @FXML
    private AccountInfo accountInfo;

    @FXML
    private Button buttonAccountInfo;
    @FXML
    private Button buttonEmployeeInfo;

    @FXML
    private EmployeeInfo employeeInfo;

    private CreateAccountMenuModel model = new CreateAccountMenuModel();

    @FXML
    public void initialize()
    {
        accountInfo.setAccount(model.getAccount());
        employeeInfo.setEmployee(model.getEmployee());

        buttonAccountInfo.setOnAction(event ->
        {
            employeeInfo.setOpacity(0.0);
            employeeInfo.setDisable(true);
            accountInfo.setOpacity(1.0);
            accountInfo.setDisable(false);
        });

        buttonEmployeeInfo.setOnAction(event ->
        {
            employeeInfo.setOpacity(1.0);
            employeeInfo.setDisable(false);
            accountInfo.setOpacity(0.0);
            accountInfo.setDisable(true);
        });

        buttonGeneratePassword.setOnAction(event ->
        {
            accountInfo.textFieldPassword.setText(model.generatePassword(4));
        });

        buttonAdd.setOnAction(event ->
        {
            accountInfo.applyChangesToAccount();
            employeeInfo.applyChangesToEmployee();

            model.createAccount();
            Main.getInstance().replaceSceneContent("/fxml-files/admin-main-menu.fxml");
        });

        buttonCancel.setOnAction(event ->
        {
            Main.getInstance().replaceSceneContent("/fxml-files/admin-main-menu.fxml");
        });
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
