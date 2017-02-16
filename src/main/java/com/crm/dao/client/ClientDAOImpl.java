package com.crm.dao.client;

import com.crm.entity.client.Client;
import com.crm.managers.DatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class ClientDAOImpl implements ClientDAO {

    @Override
    public Long createClient(Client client) {
        return DatabaseManager.getInstance().saveEntry(client);
    }

    @Override
    public Client readClient(Long id) {
        return DatabaseManager.getInstance().getEntry(id, Client.class);
    }

    @Override
    public void updateClient(Client client) {
        DatabaseManager.getInstance().updateEntry(client);
    }

    @Override
    public void deleteClient(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, Client.class);
    }

    @Override
    public List<Client> findAll() {
        return DatabaseManager.getInstance().getEntries(Client.class);
    }

    @Override
    public Client getEntryByField(String fieldName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntryByField(fieldName, fieldValue, Client.class);
    }
}
