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
    private Client client = OrderManagerMenuModel.getInstance().getClient();

    public Client getClient()
    {
        return client;
    }

    private ClientService clientService = new ClientServiceImpl();

    public void confirm(String name, String surname, String email, String phone) throws UserExistsException, MessagingException
    {
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);

        Client clientEntry = clientService.getEntryByField("email", email);

        if (clientEntry == null)
        {
            new Thread(() ->
            {
                try
                {
                    clientService.generateClient(client);
                }
                catch (MessagingException | UserExistsException e)
                {

                }
            });
        }
        else
        {
            client = clientEntry;
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
        Main.getInstance().replaceSceneContent(new AuthorizationMenuController());
    }
}
