package com.crm.service.client;

import com.crm.dao.GenericDao;
import com.crm.entity.client.Client;
import com.crm.service.GenericServiceImpl;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class ClientServiceImpl extends GenericServiceImpl<Client, Long>
{
    public ClientServiceImpl(GenericDao<Client, Long> dao)
    {
        super(dao);
    }
}
