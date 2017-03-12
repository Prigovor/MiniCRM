package com.crm.menu.admin.employee;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.employee.Employee;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.admin.employee.create.EmployeeCreationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Bohdan on 06.03.2017.
 */
@Getter @Setter
public class EmployeeManagementModel
{
    private Employee selectedEmployee;

    public void addEmployee()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/employee/create/set-main-employee-data-menu.fxml");
    }

    public void changeEmployee()
    {
        EmployeeCreationModel.getInstance().setEmployeeToCreate(selectedEmployee);
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/employee/create/set-main-employee-data-menu.fxml");
    }

    public void deleteEmployee()
    {
        FactoryService.getEmployeeService().deleteEntry(selectedEmployee.getId());
    }

    public void generateEmployee()
    {

    }

    public List<Employee> getListEmployers()
    {
        return FactoryService.getEmployeeService().getEntries();
    }

    public List<Account> getListAccounts()
    {
        return FactoryService.getAccountService().getEntries();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/admin-main-menu.fxml");
    }
}
