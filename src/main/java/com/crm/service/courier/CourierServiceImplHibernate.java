package com.crm.service.courier;

import com.crm.dao.FactoryDao;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class CourierServiceImplHibernate extends CourierServiceImpl
{
    public CourierServiceImplHibernate()
    {
        super(FactoryDao.getCourierDao());
    }
}
