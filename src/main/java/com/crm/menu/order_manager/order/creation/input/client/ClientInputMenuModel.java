package com.crm.menu.order_manager.order.creation.input.client;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.order.Order;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.client.ClientService;
import com.crm.main.Main;
import com.crm.managers.EmailManager;
import com.crm.menu.order_manager.order.creation.OrderCreationModel;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ClientInputMenuModel
{
    private Client client = OrderCreationModel.getInstance().getClient();
    private Order order = OrderCreationModel.getInstance().getOrder();

    private ClientService clientService = FactoryService.getClientService();

    public void confirm(String name, String surname, String email, String phone)
    {
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);

        Client clientEntry = clientService.getEntryByField("email", client.getEmail());
        if (clientEntry == null)
        {
            String generatedPassword = PasswordManager.getInstance().generatePassword(8);
            client.setPassword(generatedPassword);

            EmailManager.getInstance().sendClientData(client, generatedPassword);

            clientService.saveEntry(client);
        }
        else
        {
            client = clientEntry;
        }

        order.setClient(client);

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/good/good-choose-menu.fxml");
    }

    public void back()
    {
        OrderCreationModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/main/order-manager-main-menu.fxml");
    }
}
