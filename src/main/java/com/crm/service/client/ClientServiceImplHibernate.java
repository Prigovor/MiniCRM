package com.crm.service.client;

import com.crm.dao.FactoryDao;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class ClientServiceImplHibernate extends ClientServiceImpl
{
    public ClientServiceImplHibernate()
    {
        super(FactoryDao.getClientDao());
    }
}
