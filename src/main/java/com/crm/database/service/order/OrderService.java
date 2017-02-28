package com.crm.database.service.order;

import com.crm.database.dao.GenericDao;
import com.crm.database.service.GenericServiceImpl;
import com.crm.database.entity.order.Order;

/**
 * Created by Prigovor on 15.02.2017.
 */
public class OrderService extends GenericServiceImpl<Order, Long>
{
    public OrderService(GenericDao<Order, Long> dao)
    {
        super(dao);
    }
}