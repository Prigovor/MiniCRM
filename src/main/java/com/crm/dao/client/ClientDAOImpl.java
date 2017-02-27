package com.crm.dao.client;

import com.crm.entity.client.Client;
import com.crm.managers.database.HibernateDatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class ClientDAOImpl implements ClientDAO {

    @Override
    public Long createClient(Client client) {
        return HibernateDatabaseManager.getInstance().saveEntry(client);
    }

    @Override
    public Client readClient(Long id) {
        return HibernateDatabaseManager.getInstance().getEntry(id, Client.class);
    }

    @Override
    public void updateClient(Client client) {
        HibernateDatabaseManager.getInstance().updateEntry(client);
    }

    @Override
    public void deleteClient(Long id) {
        HibernateDatabaseManager.getInstance().deleteEntry(id, Client.class);
    }

    @Override
    public List<Client> findAll() {
        return HibernateDatabaseManager.getInstance().getEntries(Client.class);
    }

    @Override
    public Client getEntryByField(String fieldName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntryByField(fieldName, fieldValue, Client.class);
    }

    @Override
    public List<Client> getEntriesByField(String fieldName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntriesByField(fieldName, fieldValue, Client.class);
    }
}
