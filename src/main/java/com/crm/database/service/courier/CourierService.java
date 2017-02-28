package com.crm.database.service.courier;

import com.crm.database.dao.GenericDao;
import com.crm.database.service.GenericServiceImpl;
import com.crm.database.entity.employee.courier.Courier;

/**
 * Created by Prigovor on 16.02.2017.
 */
public class CourierService extends GenericServiceImpl<Courier, Long>
{
    public CourierService(GenericDao<Courier, Long> dao)
    {
        super(dao);
    }
}