package com.crm.menu.order_manager.client;

import com.crm.database.entity.client.Client;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.order_manager.client.create.ClientCreationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Bohdan on 14.03.2017.
 */
@Getter @Setter
public class ClientManagementModel
{
    private Client selectedClient;

    public void addClient()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/client/create/client-data.fxml");
    }

    public void changeClient()
    {
        ClientCreationModel.getInstance().setClient(selectedClient);
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/client/create/client-data.fxml");
    }

    public void deleteClient()
    {
        FactoryService.getClientService().deleteEntry(selectedClient.getId());
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order-manager-main-menu.fxml");
    }

    public String getClientInfo()
    {
        return String.format("Name - %s\nSurname - %s\nEmail - %s\nPhone - %s",
                selectedClient.getName(), selectedClient.getSurname(), selectedClient.getEmail(), selectedClient.getPhone());
    }

    public List<Client> getListClients()
    {
        return FactoryService.getClientService().getEntries();
    }

    public void generateClient()
    {

    }
}
