package com.crm.service.good;

import com.crm.dao.GenericDao;
import com.crm.entity.good.Good;
import com.crm.service.GenericServiceImpl;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class GoodServiceImpl extends GenericServiceImpl<Good, Long>
{
    public GoodServiceImpl(GenericDao<Good, Long> dao)
    {
        super(dao);
    }
}