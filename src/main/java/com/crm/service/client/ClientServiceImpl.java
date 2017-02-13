package com.crm.service.client;

import com.crm.dao.client.ClientDAO;
import com.crm.dao.client.ClientDAOImpl;
import com.crm.entity.client.Client;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO = new ClientDAOImpl();

    @Override
    public Long createClient(Client client) {
        return clientDAO.createClient(client);
    }

    @Override
    public Client readClient(Long id) {
        return clientDAO.readClient(id);
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientDAO.deleteClient(id);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }
}
