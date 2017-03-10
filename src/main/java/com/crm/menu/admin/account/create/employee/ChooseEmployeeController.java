package com.crm.menu.admin.account.create.employee;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.RightType;
import com.crm.database.entity.employee.Employee;
import com.crm.database.validation.ValidationException;
import com.crm.menu.admin.account.create.AccountCreationModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.util.Optional;

/**
 * Created by Bohdan on 04.03.2017.
 */
public class ChooseEmployeeController
{
    public ListView<Employee> listViewFreeEmployers;

    public Button buttonConfirm;
    public Button buttonBack;
    public Button buttonCancel;

    private ChooseEmployeeModel model = new ChooseEmployeeModel();

    @FXML
    public void initialize()
    {
        listViewFreeEmployers.setItems(FXCollections.observableList(model.getListFreeEmployers()));

        Employee accountEmployee = AccountCreationModel.getInstance().getAccountToCreate().getEmployee();

        if (accountEmployee != null)
        {
            if (!listViewFreeEmployers.getItems().contains(accountEmployee))
            {
                listViewFreeEmployers.getItems().add(accountEmployee);
            }
            listViewFreeEmployers.getSelectionModel().select(accountEmployee);
        }

        buttonConfirm.setOnAction(event ->
        {
            Employee selectedEmployee = listViewFreeEmployers.getSelectionModel().getSelectedItem();

            if (selectedEmployee != null)
            {
                try
                {
                    model.setAccountEmployee(selectedEmployee);
                    model.confirm();
                }
                catch (ValidationException e)
                {
                    confirmAccountAutoGeneration(selectedEmployee, e.getMessage());
                }
            }
            else
            {
                showInformationMessage("Choose employee from the list");
            }
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

    private void confirmAccountAutoGeneration(Employee employee, String message)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(message);
        alert.setContentText("Do you want to automatically generate login for account and set other fields to defaults?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Account account = AccountCreationModel.getInstance().getAccountToCreate();

            account.setRightType(RightType.USER);
            account.setLockType(LockType.UNLOCKED);

            account.setLogin(employee.getName().toLowerCase()
                            .concat(".").concat(employee.getSurname().toLowerCase()));

            model.setAccountEmployee(employee);
            model.confirm();
        }
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
