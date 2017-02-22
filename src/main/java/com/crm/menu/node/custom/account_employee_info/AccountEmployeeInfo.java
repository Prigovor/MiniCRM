package com.crm.menu.node.custom.account_employee_info;

import com.crm.entity.account.Account;
import com.crm.entity.employee.Employee;
import com.crm.menu.node.custom.account_info.AccountInfo;
import com.crm.menu.node.custom.employee_info.EmployeeInfo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Bohdan on 22.02.2017.
 */
public class AccountEmployeeInfo extends AnchorPane
{
    public AccountInfo accountInfo;
    public EmployeeInfo employeeInfo;

    public Button buttonShowInfo;

    private Account account;
    private Employee employee;

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
        accountInfo.setAccount(account);
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
        employeeInfo.setEmployee(employee);
    }

    public AccountEmployeeInfo()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml-files/custom-panes/account-employee-info.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();

            buttonShowInfo.setOnAction(event ->
            {
                if (accountInfo.getOpacity() > 0.0)
                {
                    buttonShowInfo.setText("Show account info");
                    accountInfo.setOpacity(0.0);
                }
                else
                {
                    buttonShowInfo.setText("Show employee info");
                    accountInfo.setOpacity(1.0);
                }
            });
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
