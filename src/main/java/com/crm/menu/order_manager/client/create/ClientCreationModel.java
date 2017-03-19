package com.crm.menu.order_manager.client.create;

import com.crm.database.entity.client.Client;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.managers.EmailManager;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 14.03.2017.
 */
@Getter @Setter
public class ClientCreationModel
{
    private static final ClientCreationModel instance = new ClientCreationModel();

    public static ClientCreationModel getInstance()
    {
        return instance;
    }

    private ClientCreationModel()
    {

    }

    private Client client = new Client();

    private String generatedPassword;

    public void saveClient()
    {
        generatedPassword = PasswordManager.getInstance().generatePassword(4);
        client.setPassword(generatedPassword);

        FactoryService.getClientService().saveOrUpdate(client);

        EmailManager.getInstance().sendClientData(client, generatedPassword);
    }

    public void close()
    {
        client = new Client();

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/client/client-management-menu.fxml");
    }
}
