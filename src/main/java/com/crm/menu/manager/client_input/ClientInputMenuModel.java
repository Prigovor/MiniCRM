package com.crm.menu.manager.client_input;

import com.crm.entity.client.Client;
import com.crm.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.manager.OrderManagerMenuModel;
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
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    private ClientService clientService = new ClientServiceImpl();

    public void confirm(String name, String surname, String email, String phone) throws AccountExistsException, MessagingException
    {
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);

        client.setLogin(name.toLowerCase().concat(".").concat(surname.toLowerCase()));

        Client clientEntry = clientService.getEntryByField("login", client.getLogin());
        if (clientEntry == null)
        {
            clientService.createClient(client);
        }
        else
        {
            client = clientEntry;
        }

        order.setClient(client);

        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/good-choose-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }

    public void back()
    {
        OrderManagerMenuModel.getInstance().clearData();
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
        }
        catch (IOException e)
        {

        }
    }
}
