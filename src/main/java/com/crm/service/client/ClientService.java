package com.crm.service.client;

import com.crm.entity.client.Client;
import com.crm.service.UserExistsException;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public interface ClientService {

    Long createClient(Client client) throws UserExistsException;

    Client readClient(Long id);

    void updateClient(Client client);

    void deleteClient(Long id);

    List<Client> findAll();

    Client getEntryByField(String fieldName, Object fieldValue);

    Long generateClient(Client client) throws MessagingException, UserExistsException;
}
