package com.crm.menu.admin.account.create.employee;

import com.crm.database.entity.employee.Employee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Created by Bohdan on 04.03.2017.
 */
public class AccountEmployeeController
{
    public ListView<Employee> listViewFreeEmployers;

    public Button buttonConfirm;
    public Button buttonBack;
    public Button buttonCancel;

    private AccountEmployeeModel model = new AccountEmployeeModel();

    @FXML
    public void initialize()
    {
        listViewFreeEmployers.setItems(FXCollections.observableList(model.getListFreeEmployers()));

        buttonConfirm.setOnAction(event ->
        {
            model.setAccountEmployee(listViewFreeEmployers.getSelectionModel().getSelectedItem());
        });

        buttonBack.setOnAction(event ->
        {
            model.back();
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }
}
