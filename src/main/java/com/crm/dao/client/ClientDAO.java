package com.crm.dao.client;

import com.crm.entity.client.Client;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public interface ClientDAO {

    Long createClient(Client client);

    Client readClient(Long id);

    void updateClient(Client client);

    void deleteClient(Long id);

    List<Client> findAll();

    Client getEntryByField(String fieldName, Object fieldValue);

    List<Client> getEntriesByField(String fieldName, Object fieldValue);
}