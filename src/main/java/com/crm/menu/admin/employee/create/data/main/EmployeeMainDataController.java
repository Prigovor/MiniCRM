package com.crm.menu.admin.employee.create.data.main;

import com.crm.database.entity.employee.Employee;
import com.crm.database.validation.ValidationException;
import com.crm.menu.admin.employee.create.EmployeeCreationModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 06.03.2017.
 */
public class EmployeeMainDataController
{
    public TextField textFieldName;
    public TextField textFieldSurname;
    public TextField textFieldEmail;
    public TextField textFieldPhone;

    public Button buttonNext;
    public Button buttonCancel;

    private EmployeeMainDataModel model = new EmployeeMainDataModel();

    @FXML
    public void initialize()
    {
        Employee employee = EmployeeCreationModel.getInstance().getEmployeeToCreate();

        textFieldName.setText(employee.getName());
        textFieldSurname.setText(employee.getSurname());
        textFieldEmail.setText(employee.getEmail());
        textFieldPhone.setText(employee.getPhone());

        buttonNext.setOnAction(event ->
        {
            try
            {

                model.setMainEmployeeData(textFieldName.getText(), textFieldSurname.getText(),
                        textFieldEmail.getText(), textFieldPhone.getText());
                model.next();
            }
            catch (ValidationException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
