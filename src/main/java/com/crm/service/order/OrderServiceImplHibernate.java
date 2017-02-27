package com.crm.service.order;

import com.crm.dao.FactoryDao;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class OrderServiceImplHibernate extends OrderServiceImpl
{
    public OrderServiceImplHibernate()
    {
        super(FactoryDao.getOrderDao());
    }
}
