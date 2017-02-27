package com.crm.service.courier;

import com.crm.dao.GenericDao;
import com.crm.entity.employee.courier.Courier;
import com.crm.service.GenericServiceImpl;

/**
 * Created by Prigovor on 16.02.2017.
 */
public class CourierServiceImpl extends GenericServiceImpl<Courier, Long>
{
    public CourierServiceImpl(GenericDao<Courier, Long> dao)
    {
        super(dao);
    }
}