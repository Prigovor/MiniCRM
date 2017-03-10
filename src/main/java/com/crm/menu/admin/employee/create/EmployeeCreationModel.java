package com.crm.menu.admin.employee.create;

import com.crm.database.entity.EntityTransformer;
import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.courier.Courier;
import com.crm.database.entity.employee.order_manager.OrderManager;
import com.crm.database.entity.employee.storekeeper.Storekeeper;
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
        switch (employeeToCreate.getPosition())
        {
            case COURIER:
            {
                employeeToCreate = EntityTransformer.getTransformedEmployee(employeeToCreate, new Courier());
                break;
            }
            case STOREKEEPER:
            {
                employeeToCreate = EntityTransformer.getTransformedEmployee(employeeToCreate, new Storekeeper());
                break;
            }
            case ORDER_MANAGER:
            {
                employeeToCreate = EntityTransformer.getTransformedEmployee(employeeToCreate, new OrderManager());
                break;
            }
        }

        FactoryService.getEmployeeService(DatabaseManagerType.HIBERNATE).saveOrUpdate(employeeToCreate);
    }

    public void close()
    {
        employeeToCreate = new Employee();
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/employee/employee-management-menu.fxml");
    }
}
