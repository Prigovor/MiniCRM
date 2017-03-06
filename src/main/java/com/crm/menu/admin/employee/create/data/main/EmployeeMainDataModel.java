package com.crm.menu.admin.employee.create.data.main;

import com.crm.database.entity.employee.Employee;
import com.crm.database.validation.EntityValidator;
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

        EntityValidator.getInstance().validateEntry(employee);
    }

    public void next()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/admin/employee-creation/set-secondary-employee-data-menu.fxml");
    }

    public void cancel()
    {
        EmployeeCreationModel.getInstance().cancel();
    }
}
