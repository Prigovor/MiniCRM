package com.crm.menu.order.manager.main;

import com.crm.main.Main;
import com.crm.menu.authorization.AuthorizationMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Created by Bohdan on 19.02.2017.
 */
public class ManagerMainMenuController
{
    public Button buttonCreateOrder;
    public Button buttonUnlogin;

    @FXML
    public void initialize()
    {
        buttonCreateOrder.setOnAction(event ->
        {
            try
            {
                Main.getInstance().replaceSceneContent("/fxml-files/client-input-menu.fxml");
            }
            catch (IOException e)
            {

            }
        });

        buttonUnlogin.setOnAction(event ->
        {
            Main.getInstance().replaceSceneContent(new AuthorizationMenuController());
        });
    }
}
