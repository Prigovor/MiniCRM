package com.crm.menu.admin.employee;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
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
 * Created by Bohdan on 06.03.2017.
 */
public class EmployeeManagementController
{
    public ListView<Employee> listViewEmployers;

    public AccountInfo accountInfo;
    public EmployeeInfo employeeInfo;

    public TableView tableView;

    public Button buttonShowAccountInfo;
    public Button buttonShowEmployeeInfo;

    public Button buttonDeleteEmployee;
    public Button buttonChangeEmployee;
    public Button buttonAddEmployee;

    public Button buttonGenerateEmployee;

    public Button buttonShowAllAccounts;
    public Button buttonShowAllEmployers;

    public Button buttonBack;
    public Button buttonRefresh;

    private EmployeeManagementModel model = new EmployeeManagementModel();

    @FXML
    public void initialize()
    {
        listViewEmployers.setItems(FXCollections.observableList(model.getListEmployers()));

        listViewEmployers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            model.setSelectedEmployee(newValue);
        });

        buttonShowEmployeeInfo.setOnAction(event ->
        {
            showEmployeeInfo();
        });

        buttonShowAccountInfo.setOnAction(event ->
        {
            showAccountInfo();
        });

        buttonAddEmployee.setOnAction(event ->
        {
            addEmployee();
        });

        buttonChangeEmployee.setOnAction(event ->
        {
            changeEmployee();
        });

        buttonDeleteEmployee.setOnAction(event ->
        {
            deleteEmployee();
        });

        buttonGenerateEmployee.setOnAction(event ->
        {
            generateEmployee();
        });

        buttonShowAllEmployers.setOnAction(event ->
        {
            showAllEmployers();
        });

        buttonShowAllAccounts.setOnAction(event ->
        {
            showAllAccounts();
        });

        buttonRefresh.setOnAction(event ->
        {
            refreshView();
        });

        buttonBack.setOnAction(event ->
        {
            back();
        });
    }

    private void runDatabaseListener(long listenInterval)
    {
    }

    private void back()
    {
        model.back();
    }

    private void generateEmployee()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource File");

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Json files", "*.json");

        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);

        File file = fileChooser.showOpenDialog(null);

        if (file != null)
        {
            model.generateEmployee();
            refreshView();
        }
    }

    private void deleteEmployee()
    {
        if (model.getSelectedEmployee() != null)
        {
            model.deleteEmployee();
            refreshView();
        }
        else
        {
            showInformationMessage("Select employee in left-side list");
        }
    }

    private void changeEmployee()
    {
        if (model.getSelectedEmployee() != null)
        {
            model.changeEmloyee();
        }
        else
        {
            showInformationMessage("Select employee in left-side list");
        }
    }

    private void addEmployee()
    {
        model.addEmployee();
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
        if (model.getSelectedEmployee() != null)
        {
            tableView.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            employeeInfo.setOpacity(1.0);

            employeeInfo.setEmployee(model.getSelectedEmployee());
        }
        else
        {
            showInformationMessage("Select employee in left-side list");
        }
    }

    private void showAccountInfo()
    {
        if (model.getSelectedEmployee() != null)
        {
            tableView.setOpacity(0.0);
            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(1.0);

            if (model.getSelectedEmployee().getAccount() != null)
            {
                accountInfo.setAccount(model.getSelectedEmployee().getAccount());
            }
            else
            {
                showInformationMessage("Employee have not any account");
            }
        }
        else
        {
            showInformationMessage("Select employee in left-side list");
        }
    }

    private void refreshView()
    {
        listViewEmployers.setItems(FXCollections.observableList(model.getListEmployers()));

        accountInfo.clear();
        employeeInfo.clear();
        tableView.getItems().clear();
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
