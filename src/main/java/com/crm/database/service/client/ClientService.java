package com.crm.database.service.client;

import com.crm.database.dao.GenericDao;
import com.crm.database.service.GenericServiceImpl;
import com.crm.database.entity.client.Client;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class ClientService extends GenericServiceImpl<Client, Long>
{
    public ClientService(GenericDao<Client, Long> dao)
    {
        super(dao);
    }
}
