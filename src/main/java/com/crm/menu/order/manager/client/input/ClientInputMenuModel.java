package com.crm.menu.order.manager.client.input;

import com.crm.entity.client.Client;
import com.crm.menu.order.manager.OrderManagerMenuModel;
import com.crm.service.UserExistsException;
import com.crm.service.client.ClientService;
import com.crm.service.client.ClientServiceImpl;

import javax.mail.MessagingException;

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
            clientService.generateClient(client);
        }
        else
        {
            client = clientEntry;
        }
    }

    public void cancel()
    {

    }

    public void back()
    {

    }
}
