package com.crm.menu.admin;

import com.crm.entity.account.Account;
import com.crm.entity.employee.Employee;
import com.crm.main.Main;
import com.crm.main.MainModel;
import com.crm.menu.node.custom.account_info.AccountInfo;
import com.crm.menu.node.custom.employee_info.EmployeeInfo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Bohdan on 22.02.2017.
 */

public class AdminMenuController
{
    @FXML
    private ListView<Account> listViewAccounts;

    @FXML
    private Button buttonShowAccountInfo;
    @FXML
    private Button buttonShowEmployeeInfo;

    @FXML
    private Button buttonDeleteAccount;
    @FXML
    private Button buttonChangeAccount;
    @FXML
    private Button buttonAddAccount;
    @FXML
    private Button buttonGenerateAccount;

    @FXML
    private Button buttonShowAllAccounts;
    @FXML
    private Button buttonShowAllEmployers;
    @FXML
    private Button buttonLogOut;

    @FXML
    private AccountInfo accountInfo;
    @FXML
    private EmployeeInfo employeeInfo;

    @FXML
    private TableView tableView;

    private AdminMenuModel model = AdminMenuModel.getInstance();

    @FXML
    public void initialize()
    {
        listViewAccounts.setItems(FXCollections.observableList(model.getListAccounts()));

        listViewAccounts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            model.setSelectedAccount(newValue);
        });

        buttonShowAccountInfo.setOnAction(event ->
        {
            tableView.setOpacity(0.0);
            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(1.0);

            if (model.getSelectedAccount() != null)
            {
                accountInfo.setAccount(model.getSelectedAccount());
            }
            else
            {
                showInformationMessage("Select account in left-side list");
            }
        });

        buttonShowEmployeeInfo.setOnAction(event ->
        {
            tableView.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            employeeInfo.setOpacity(1.0);

            if (model.getSelectedAccount() != null)
            {
                if (model.getSelectedAccount().getEmployee() != null)
                {
                    employeeInfo.setEmployee(model.getSelectedAccount().getEmployee());
                }
                else
                {
                    showInformationMessage("Selected account does not refer to any employee");
                }
            }
            else
            {
                showInformationMessage("Select account in left-side list");
            }
        });

        buttonShowAllAccounts.setOnAction(event ->
        {
            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            tableView.setOpacity(1.0);

            tableView.setItems(FXCollections.observableList(model.getListAccounts()));

            tableView.getColumns().clear();
            for (Field field : Account.class.getDeclaredFields())
            {
                TableColumn tableColumn = new TableColumn(field.getName());
                tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
                tableView.getColumns().add(tableColumn);
            }
        });

        buttonShowAllEmployers.setOnAction(event ->
        {
            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            tableView.setOpacity(1.0);

            tableView.setItems(FXCollections.observableList(model.getListEmployers()));

            tableView.getColumns().clear();
            for (Field field : Employee.class.getDeclaredFields())
            {
                TableColumn tableColumn = new TableColumn(field.getName());
                tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
                tableView.getColumns().add(tableColumn);
            }
        });

        buttonAddAccount.setOnAction(event ->
        {
            try
            {
                Main.getInstance().replaceSceneContent("/fxml-files/admin-add-account-menu.fxml");
            }
            catch (IOException e)
            {

            }
        });

        buttonChangeAccount.setOnAction(event ->
        {
            if (model.getSelectedAccount() != null)
            {
                try
                {
                    Main.getInstance().replaceSceneContent("/fxml-files/admin-change-account-menu.fxml");
                }
                catch (IOException e)
                {

                }
            }
            else
            {
                showInformationMessage("Select account in left-side list");
            }
        });

        buttonDeleteAccount.setOnAction(event ->
        {
            if (model.getSelectedAccount() != null)
            {
                model.deleteAccount();
            }
            else
            {
                showInformationMessage("Select account in left-side list");
            }
        });

        buttonGenerateAccount.setOnAction(event ->
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open resource File");

            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Json files", "*.json");

            fileChooser.getExtensionFilters().add(filter);
            fileChooser.setSelectedExtensionFilter(filter);

            File file = fileChooser.showOpenDialog(null);

            if (file != null)
            {
                try
                {
                    model.generateAccount(file.getAbsolutePath());
                }
                catch (IOException | MessagingException e)
                {

                }
            }
        });

        buttonLogOut.setOnAction(event ->
        {

        });
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
