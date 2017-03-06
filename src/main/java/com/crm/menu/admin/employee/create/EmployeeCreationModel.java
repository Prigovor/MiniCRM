package com.crm.menu.admin.employee.create;

import com.crm.database.entity.employee.Employee;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 06.03.2017.
 */
@Getter @Setter
public class EmployeeCreationModel
{
    private static final EmployeeCreationModel instance = new EmployeeCreationModel();

    public static EmployeeCreationModel getInstance()
    {
        return instance;
    }

    private EmployeeCreationModel()
    {

    }

    private Employee employeeToCreate = new Employee();

    public void saveEmployee()
    {
        FactoryService.getEmployeeService(DatabaseManagerType.HIBERNATE).saveOrUpdate(employeeToCreate);
    }

    public void cancel()
    {
        employeeToCreate = new Employee();
        Main.getInstance().replaceSceneContent("/fxml-files/admin/admin-main-menu.fxml");
    }
}
