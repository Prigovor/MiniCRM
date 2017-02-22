package com.crm.menu.admin;

import com.crm.entity.account.Account;
import com.crm.entity.employee.Employee;
import com.crm.menu.node.custom.account_info.AccountInfo;
import com.crm.menu.node.custom.employee_info.EmployeeInfo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 22.02.2017.
 */

public class AdminMenuController
{
    @FXML private ListView<Account> listViewAccounts;

    @FXML private Button buttonShowAccountInfo;
    @FXML private Button buttonShowEmployeeInfo;

    @FXML private Button buttonDeleteAccount;
    @FXML private Button buttonChangeAccount;
    @FXML private Button buttonAddAccount;
    @FXML private Button buttonGenerateAccount;

    @FXML private Button buttonShowAllAccounts;
    @FXML private Button buttonShowAllEmployers;

    @FXML private AccountInfo accountInfo;
    @FXML private EmployeeInfo employeeInfo;

    @FXML private TableView tableView;

    private AdminMenuModel adminMenuModel = AdminMenuModel.getInstance();

    @FXML
    public void initialize()
    {
        listViewAccounts.setItems(FXCollections.observableList(adminMenuModel.getListAccounts()));

        listViewAccounts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            adminMenuModel.setSelectedAccount(newValue);
        });

        buttonShowAccountInfo.setOnAction(event ->
        {
            tableView.setOpacity(0.0);
            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(1.0);

            if (adminMenuModel.getSelectedAccount() != null)
            {
                accountInfo.setAccount(adminMenuModel.getSelectedAccount());
            }
        });

        buttonShowEmployeeInfo.setOnAction(event ->
        {
            tableView.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            employeeInfo.setOpacity(1.0);

            if (adminMenuModel.getSelectedAccount() != null && adminMenuModel.getSelectedAccount().getEmployee() != null)
            {
                employeeInfo.setEmployee(adminMenuModel.getSelectedAccount().getEmployee());
            }
        });

        buttonShowAllAccounts.setOnAction(event ->
        {
            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            tableView.setOpacity(1.0);

            tableView.getColumns().clear();
            for (Field field : Account.class.getDeclaredFields())
            {
                TableColumn tableColumn = new TableColumn(field.getName());
                tableView.getColumns().add(tableColumn);
            }
        });

        buttonShowAllEmployers.setOnAction(event ->
        {

            employeeInfo.setOpacity(0.0);
            accountInfo.setOpacity(0.0);
            tableView.setOpacity(1.0);

            tableView.getColumns().clear();
            for (Field field : Employee.class.getDeclaredFields())
            {
                TableColumn tableColumn = new TableColumn(field.getName());
                tableView.getColumns().add(tableColumn);
            }
        });
    }
}
