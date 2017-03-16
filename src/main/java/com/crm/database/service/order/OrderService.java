package com.crm.database.service.order;

import com.crm.database.entity.order.Order;
import com.crm.database.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Prigovor on 15.02.2017.
 */
@Service
public class OrderService extends GenericServiceImpl<Order, Long>
{
    @Override
    public Long saveEntry(Order entry)
    {
        return super.saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(Order entry)
    {
        super.saveOrUpdate(entry);
    }

    @Override
    public void updateEntry(Order entry)
    {
        super.updateEntry(entry);
    }
}