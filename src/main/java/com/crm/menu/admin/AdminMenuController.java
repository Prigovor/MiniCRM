package com.crm.menu.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Bohdan on 22.02.2017.
 */

public class AdminMenuController
{
    public Button buttonAccountsManagement;
    public Button buttonEmployersManagement;
    public Button buttonLogOut;

    private AdminMenuModel model = new AdminMenuModel();

    @FXML
    public void initialize()
    {
        buttonAccountsManagement.setOnAction(event ->
        {
            model.goToAccountManagement();
        });

        buttonEmployersManagement.setOnAction(event ->
        {
            model.goToEmployeeManagement();
        });

        buttonLogOut.setOnAction(event ->
        {
            model.logOut();
        });
    }
}
