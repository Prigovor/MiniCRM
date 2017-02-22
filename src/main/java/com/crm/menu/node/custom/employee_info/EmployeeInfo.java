package com.crm.menu.node.custom.employee_info;

import com.crm.entity.employee.Employee;
import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Bohdan on 22.02.2017.
 */
public class EmployeeInfo extends AnchorPane
{
    public TextField textFieldName;
    public TextField textFieldSurname;
    public TextField textFieldEmail;
    public TextField textFieldPhone;
    public TextField textFieldAge;

    public ChoiceBox choiceBoxGender;
    public ChoiceBox choiceBoxPosition;

    private Employee employee;

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;

        textFieldName.setText(employee.getName());
        textFieldSurname.setText(employee.getSurname());
        textFieldEmail.setText(employee.getEmail());
        textFieldPhone.setText(employee.getPhone());
        textFieldAge.setText(String.valueOf(employee.getAge()));

        choiceBoxGender.setValue(employee.getGender());
        choiceBoxPosition.setValue(employee.getPosition());
    }

    public EmployeeInfo()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml-files/custom-panes/employee-info.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();

            choiceBoxGender.setItems(FXCollections.observableList(Arrays.asList(Gender.values())));
            choiceBoxPosition.setItems(FXCollections.observableList(Arrays.asList(PositionType.values())));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
