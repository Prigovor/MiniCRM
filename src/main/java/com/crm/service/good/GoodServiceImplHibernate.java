package com.crm.service.good;

import com.crm.dao.FactoryDao;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class GoodServiceImplHibernate extends GoodServiceImpl
{
    public GoodServiceImplHibernate()
    {
        super(FactoryDao.getGoodDao());
    }
}
