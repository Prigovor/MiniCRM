package com.crm.menu.admin.employee.create.data.main;

import com.crm.database.entity.employee.Employee;
import com.crm.database.validation.DataValidator;
import com.crm.main.Main;
import com.crm.menu.admin.employee.create.EmployeeCreationModel;

/**
 * Created by Bohdan on 06.03.2017.
 */
public class EmployeeMainDataModel
{
    public void setMainEmployeeData(String name, String surname, String email, String phone)
    {
        Employee employee = EmployeeCreationModel.getInstance().getEmployeeToCreate();

        employee.setName(name);
        employee.setSurname(surname);
        employee.setEmail(email);
        employee.setPhone(phone);

        DataValidator.getInstance().validateNotBlankField(employee.getName(), 1, "Name");
        DataValidator.getInstance().validateNotBlankField(employee.getSurname(), 1, "Surname");
        DataValidator.getInstance().validateEmail(employee.getEmail());
        DataValidator.getInstance().validatePhone(employee.getPhone());
    }

    public void next()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/employee/create/set-secondary-employee-data-menu.fxml");
    }

    public void cancel()
    {
        EmployeeCreationModel.getInstance().close();
    }
}
