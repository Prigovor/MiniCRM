package com.crm.menu.order.manager.client.input;

import com.crm.entity.client.Client;
import com.crm.main.Main;
import com.crm.menu.authorization.AuthorizationMenuController;
import com.crm.menu.order.manager.OrderManagerMenuModel;
import com.crm.service.UserExistsException;
import com.crm.service.client.ClientService;
import com.crm.service.client.ClientServiceImpl;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ClientInputMenuModel
{
    private ClientService clientService = new ClientServiceImpl();

    public void confirm(String name, String surname, String email, String phone) throws UserExistsException, MessagingException
    {
        OrderManagerMenuModel.getInstance().getClient().setName(name);
        OrderManagerMenuModel.getInstance().getClient().setSurname(surname);
        OrderManagerMenuModel.getInstance().getClient().setEmail(email);
        OrderManagerMenuModel.getInstance().getClient().setPhone(phone);

        Client clientEntry = clientService.getEntryByField("email", email);

        if (clientEntry == null)
        {
            new Thread(() ->
            {
                try
                {
                    clientService.generateClient(OrderManagerMenuModel.getInstance().getClient());
                }
                catch (MessagingException | UserExistsException e)
                {
                    e.printStackTrace();
                }
            });
        }
        else
        {
            OrderManagerMenuModel.getInstance().setClient(clientEntry);
        }

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
