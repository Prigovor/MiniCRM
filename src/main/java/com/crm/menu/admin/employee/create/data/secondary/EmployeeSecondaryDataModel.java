package com.crm.menu.admin.employee.create.data.secondary;

import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.Gender;
import com.crm.database.entity.employee.PositionType;
import com.crm.main.Main;
import com.crm.menu.admin.employee.create.EmployeeCreationModel;

/**
 * Created by Bohdan on 06.03.2017.
 */
public class EmployeeSecondaryDataModel
{
    public void setSecondaryEmployeeData(Integer age, Gender gender, PositionType positionType)
    {
        Employee employee = EmployeeCreationModel.getInstance().getEmployeeToCreate();

        employee.setAge(age);
        employee.setGender(gender);
        employee.setPosition(positionType);
    }

    public void confirm()
    {
        EmployeeCreationModel.getInstance().saveEmployee();
        EmployeeCreationModel.getInstance().close();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/employee/create/set-main-employee-data-menu.fxml");
    }

    public void cancel()
    {
        EmployeeCreationModel.getInstance().close();
    }
}
