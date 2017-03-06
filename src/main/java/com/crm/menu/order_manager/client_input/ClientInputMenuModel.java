package com.crm.menu.order_manager.client_input;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.order.Order;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.database.service.client.ClientService;
import com.crm.main.Main;
import com.crm.menu.order_manager.OrderManagerMenuModel;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ClientInputMenuModel
{
    private Client client = OrderManagerMenuModel.getInstance().getClient();
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    private ClientService clientService = FactoryService.getClientService(DatabaseManagerType.HIBERNATE);

    public void confirm(String name, String surname, String email, String phone)
    {
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);

        client.setLogin(name.toLowerCase().concat(".").concat(surname.toLowerCase()));

        Client clientEntry = clientService.getEntryByField("login", client.getLogin());
        if (clientEntry == null)
        {
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
