package com.crm.menu.order_manager.client_input;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.order.Order;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.service.client.ClientService;
import com.crm.main.Main;
import com.crm.managers.EmailManager;
import com.crm.menu.order_manager.OrderManagerMenuModel;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ClientInputMenuModel
{
    private Client client = OrderManagerMenuModel.getInstance().getClient();
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

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

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/good/good-choose-menu.fxml");
    }

    public void back()
    {
        OrderManagerMenuModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/main/order-manager-main-menu.fxml");
    }
}
