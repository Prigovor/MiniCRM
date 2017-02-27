package com.crm.dao.good;

import com.crm.entity.good.Good;
import com.crm.managers.database.HibernateDatabaseManager;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class GoodDAOImpl implements GoodDAO
{
    @Override
    public Long createGood(Good good)
    {
        return HibernateDatabaseManager.getInstance().saveEntry(good);
    }

    @Override
    public Good readGood(Long id)
    {
        return HibernateDatabaseManager.getInstance().getEntry(id, Good.class);
    }

    @Override
    public void updateGood(Good good)
    {
        HibernateDatabaseManager.getInstance().updateEntry(good);
    }

    @Override
    public void deleteGood(Long id)
    {
        HibernateDatabaseManager.getInstance().deleteEntry(id, Good.class);
    }

    @Override
    public List<Good> findAll()
    {
        return HibernateDatabaseManager.getInstance().getEntries(Good.class);
    }

    @Override
    public List<Good> findAllStoreGoods()
    {
        List<Good> listAllGoods = HibernateDatabaseManager.getInstance().getEntries(Good.class);

        return listAllGoods.stream().filter(good ->
                {
                    return good.getClass().equals(Good.class);
                }).collect(Collectors.toList());
    }

    @Override
    public Good getEntryByField(String fieldName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntryByField(fieldName, fieldValue, Good.class);
    }

    @Override
    public List<Good> getEntriesByField(String fieldName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntriesByField(fieldName, fieldValue, Good.class);
    }
}
