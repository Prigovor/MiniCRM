package com.crm.menu.order_manager.client.create.data;

import com.crm.database.entity.client.Client;
import com.crm.database.manager.PasswordManager;
import com.crm.menu.order_manager.client.create.ClientCreationModel;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class ClientDataModel
{
    public void setClientData(String name, String surname, String email, String phone)
    {
        Client client = ClientCreationModel.getInstance().getClient();

        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);

        String generatedPassword = PasswordManager.getInstance().generatePassword(8);

        client.setPassword(generatedPassword);

        ClientCreationModel.getInstance().setGeneratedPassword(generatedPassword);
    }

    public void confirm()
    {
        ClientCreationModel.getInstance().saveClient();
        ClientCreationModel.getInstance().close();
    }
}
