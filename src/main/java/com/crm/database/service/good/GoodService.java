package com.crm.database.service.good;

import com.crm.database.dao.GenericDao;
import com.crm.database.service.GenericServiceImpl;
import com.crm.database.entity.good.Good;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class GoodService extends GenericServiceImpl<Good, Long>
{
    public GoodService(GenericDao<Good, Long> dao)
    {
        super(dao);
    }
}