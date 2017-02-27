package com.crm.service.account;

import com.crm.dao.FactoryDao;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class AccountServiceImplHibernate extends AccountServiceImpl
{
    public AccountServiceImplHibernate()
    {
        super(FactoryDao.getAccountDao());
    }
}
