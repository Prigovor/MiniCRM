package com.crm.menu.order.manager.client.input;

import com.crm.entity.client.Client;
import com.crm.main.Main;
import com.crm.menu.authorization.AuthorizationMenuController;
import com.crm.menu.order.manager.OrderManagerMenuModel;
import com.crm.service.UserExistsException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ClientInputMenuModel
{
    private Client client = OrderManagerMenuModel.getInstance().getClient();

    public void confirm(String name, String surname, String email, String phone) throws UserExistsException, MessagingException
    {
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);

        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/good-choose-menu.fxml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void back()
    {
        OrderManagerMenuModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent(new AuthorizationMenuController());
    }
}
