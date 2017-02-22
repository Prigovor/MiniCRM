package com.crm.service.client;

import com.crm.dao.FactoryDAO;
import com.crm.dao.client.ClientDAO;
import com.crm.entity.client.Client;
import com.crm.managers.EmailManager;
import com.crm.managers.PasswordManager;
import com.crm.service.AccountExistsException;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class ClientServiceImpl implements ClientService
{
    private ClientDAO clientDAO = FactoryDAO.getClientDAO();

    @Override
    public Long createClient(Client client) throws AccountExistsException
    {
        if (getEntryByField("email", client.getEmail()) != null)
        {
            throw new AccountExistsException("Client with such email is registered");
        }

        return clientDAO.createClient(client);
    }

    @Override
    public Client readClient(Long id)
    {
        return clientDAO.readClient(id);
    }

    @Override
    public void updateClient(Client client)
    {
        clientDAO.updateClient(client);
    }

    @Override
    public void deleteClient(Long id)
    {
        clientDAO.deleteClient(id);
    }

    @Override
    public List<Client> findAll()
    {
        return clientDAO.findAll();
    }

    @Override
    public Client getEntryByField(String fieldName, Object fieldValue)
    {
        return clientDAO.getEntryByField(fieldName, fieldValue);
    }

    public Long generateClient(Client client) throws MessagingException, AccountExistsException
    {
        Client clientEntry = new Client();

        clientEntry.setLogin(client.getName().toLowerCase().concat(".").concat(client.getSurname().toLowerCase()));
        clientEntry.setPassword(PasswordManager.getInstance().generatePassword(4));

        clientEntry.setName(client.getName());
        clientEntry.setSurname(client.getSurname());
        clientEntry.setEmail(client.getEmail());
        clientEntry.setPhone(client.getPhone());

        int sameClientCount = 0;
        for (Client entry : clientDAO.findAll())
        {
            if (clientEntry.getLogin().equals(entry.getLogin()))
            {
                sameClientCount++;
            }

            if (clientEntry.getPassword().equals(entry.getPassword()))
            {
                clientEntry.setPassword(PasswordManager.getInstance().generatePassword(4));
            }
        }

        if (sameClientCount != 0)
        {
            clientEntry.setLogin(clientEntry.getLogin().concat("." + sameClientCount));
        }

        new Thread(() ->
        {
            try
            {
                EmailManager.getInstance().sendMessage(clientEntry.getEmail(), "Login and password from MiniSRM client account",
                        "Login: " + clientEntry.getLogin() + "\nPassword: " + clientEntry.getPassword());
            }
            catch (MessagingException e)
            {

            }
        }).start();

        return createClient(clientEntry);
    }
}
