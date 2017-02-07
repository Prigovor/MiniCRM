package com.crm.menu.create.account;

import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;

import java.io.IOException;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuController
{
    private CreateAccountMenuModel model = new CreateAccountMenuModel();

    public void createAccount()
    {
        User user = model.getUser();
        Employee employee = model.getEmployee();

        try
        {
            model.createAccount();
        }
        catch (CreateAccountException e)
        {

        }
        catch (IOException e)
        {

        }
    }

    public void cancel()
    {
        try
        {
            model.cancel();
        }
        catch (IOException e)
        {

        }
    }
}
