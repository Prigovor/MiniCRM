package com.crm.menu.admin;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
import com.crm.main.Main;
import com.crm.node_custom.account_info.AccountInfo;
import com.crm.node_custom.employee_info.EmployeeInfo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
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
    private Button buttonRefresh;

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
            showAccountInfo();
        });

        buttonShowEmployeeInfo.setOnAction(event ->
        {
            showEmployeeInfo();
        });

        buttonShowAllAccounts.setOnAction(event ->
        {
            showAllAccounts();
        });

        buttonShowAllEmployers.setOnAction(event ->
        {
            showAllEmployers();
        });

        buttonAddAccount.setOnAction(event ->
        {
            addAccount();
        });

        buttonChangeAccount.setOnAction(event ->
        {
            changeAccount();
        });

        buttonDeleteAccount.setOnAction(event ->
        {
            deleteAccount();
        });

        buttonGenerateAccount.setOnAction(event ->
        {
            generateAccount();
        });

        buttonRefresh.setOnAction(event ->
        {
            refreshView();
        });

        buttonLogOut.setOnAction(event ->
        {
            logOut();
        });

        runDatabaseListener(10000);
    }

    private void runDatabaseListener(long listenInterval)
    {
    }

    private void logOut()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
    }

    private void generateAccount()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource File");

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Json files", "*.json");

        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);

        File file = fileChooser.showOpenDialog(null);

        if (file != null)
        {
            model.generateAccount(file.getAbsolutePath());
            refreshView();
        }
    }

    private void deleteAccount()
    {
        if (model.getSelectedAccount() != null)
        {
            model.deleteAccount();
            refreshView();
        }
        else
        {
            showInformationMessage("Select account in left-side list");
        }
    }

    private void changeAccount()
    {
        if (model.getSelectedAccount() != null)
        {
            Main.getInstance().replaceSceneContent("/fxml-files/admin/admin-change-account-menu.fxml");
        }
        else
        {
            showInformationMessage("Select account in left-side list");
        }
    }

    private void addAccount()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/admin/set-account-data-menu.fxml");
    }

    private void showAllEmployers()
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
    }

    private void showAllAccounts()
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
    }

    private void showEmployeeInfo()
    {
        if (model.getSelectedAccount() != null)
        {
            if (model.getSelectedAccount().getEmployee() != null)
            {
                tableView.setOpacity(0.0);
                accountInfo.setOpacity(0.0);
                employeeInfo.setOpacity(1.0);

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
    }

    private void showAccountInfo()
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
    }

    private void refreshView()
    {
        listViewAccounts.setItems(FXCollections.observableList(model.getListAccounts()));

        accountInfo.clear();
        employeeInfo.clear();
        tableView.getItems().clear();
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
