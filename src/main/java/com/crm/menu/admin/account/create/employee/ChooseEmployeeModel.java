package com.crm.menu.admin.account.create.employee;

import com.crm.database.entity.employee.Employee;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.admin.account.create.AccountCreationModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class ChooseEmployeeModel
{
    public List<Employee> getListFreeEmployers()
    {
        return FactoryService.getEmployeeService().getEntries()
                .stream().filter(employee ->
                {
                    return employee.getAccount() == null;
                }).collect(Collectors.toList());
    }

    public void setAccountEmployee(Employee employee)
    {
        AccountCreationModel.getInstance().getAccountToCreate().setEmployee(employee);
    }

    public void confirm()
    {
        AccountCreationModel.getInstance().saveAccount();
        AccountCreationModel.getInstance().close();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/admin/account/create/set-account-data-menu.fxml");
    }

    public void cancel()
    {
        AccountCreationModel.getInstance().close();
    }
}