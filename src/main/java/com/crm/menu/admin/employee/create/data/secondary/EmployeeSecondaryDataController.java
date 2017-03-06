package com.crm.menu.admin.employee.create.data.secondary;

import com.crm.database.entity.employee.Gender;
import com.crm.database.entity.employee.PositionType;
import com.crm.database.validation.ValidationException;
import com.crm.menu.admin.employee.create.EmployeeCreationModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

/**
 * Created by Bohdan on 06.03.2017.
 */
public class EmployeeSecondaryDataController
{
    public TextField textFieldAge;
    public ChoiceBox<Gender> choiceBoxGender;
    public ChoiceBox<PositionType> choiceBoxPosition;

    public Button buttonConfirm;
    public Button buttonBack;
    public Button buttonCancel;

    private EmployeeSecondaryDataModel model = new EmployeeSecondaryDataModel();

    @FXML
    public void initialize()
    {
        choiceBoxGender.setItems(FXCollections.observableList(Arrays.asList(Gender.values())));
        choiceBoxPosition.setItems(FXCollections.observableList(Arrays.asList(PositionType.values())));

        textFieldAge.setText(String.valueOf(EmployeeCreationModel.getInstance().getEmployeeToCreate().getAge()));

        buttonConfirm.setOnAction(event ->
        {
            try
            {
                model.setSecondaryEmployeeData(Integer.valueOf(textFieldAge.getText()), choiceBoxGender.getValue(), choiceBoxPosition.getValue());
                model.confirm();
            }
            catch (ValidationException e)
            {
                showInformationMessage(e.getMessage());
            }
            catch (NumberFormatException e)
            {
                showInformationMessage("Enter valid number for age");
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

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
