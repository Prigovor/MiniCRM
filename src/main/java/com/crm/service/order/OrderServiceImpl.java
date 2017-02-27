package com.crm.service.order;

import com.crm.dao.GenericDao;
import com.crm.entity.order.Order;
import com.crm.service.GenericServiceImpl;

/**
 * Created by Prigovor on 15.02.2017.
 */
public class OrderServiceImpl extends GenericServiceImpl<Order, Long>
{
    public OrderServiceImpl(GenericDao<Order, Long> dao)
    {
        super(dao);
    }
}