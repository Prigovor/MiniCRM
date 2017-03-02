package com.crm.menu.admin.account.change;

import com.crm.main.Main;
import com.crm.menu.admin.AdminMenuModel;
import com.crm.node_custom.account_info.AccountInfo;
import com.crm.node_custom.employee_info.EmployeeInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;

/**
 * Created by Bohdan on 22.02.2017.
 */
public class ChangeAccountMenuController
{
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonChange;
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

    private ChangeAccountMenuModel model = new ChangeAccountMenuModel();

    @FXML
    public void initialize()
    {
        model.setAccount(AdminMenuModel.getInstance().getSelectedAccount());

        accountInfo.setAccount(AdminMenuModel.getInstance().getSelectedAccount());

        if (AdminMenuModel.getInstance().getSelectedAccount().getEmployee() != null)
        {
            employeeInfo.setEmployee(AdminMenuModel.getInstance().getSelectedAccount().getEmployee());
        }
        else
        {
            employeeInfo.setEmployee(model.getEmployee());
        }

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

        buttonChange.setOnAction(event ->
        {
            try
            {
                accountInfo.applyChangesToAccount();
                employeeInfo.applyChangesToEmployee();

                model.changeAccount();
                Main.getInstance().replaceSceneContent("/fxml-files/admin-main-menu.fxml");
            }
            catch (IOException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonGeneratePassword.setOnAction(event ->
        {
            accountInfo.textFieldPassword.setText(model.generatePassword(4));
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
