package com.crm.service.client;

import com.crm.entity.client.Client;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public interface ClientService {

    Long createClient(Client client);

    Client readClient(Long id);

    void updateClient(Client client);

    void deleteClient(Long id);

    List<Client> findAll();
}
