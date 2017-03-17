package com.crm.database.service.good;

import com.crm.database.entity.good.Good;
import com.crm.database.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Prigovor on 14.02.2017.
 */
@Service
public class GoodService extends GenericServiceImpl<Good, Long>
{
    @Override
    public Long saveEntry(Good entry)
    {
        return super.saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(Good entry)
    {
        super.saveOrUpdate(entry);
    }

    @Override
    public void updateEntry(Good entry)
    {
        super.updateEntry(entry);
    }
}