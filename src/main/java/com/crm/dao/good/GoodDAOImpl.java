package com.crm.dao.good;

import com.crm.entity.good.Good;
import com.crm.entity.good.SelectedGood;
import com.crm.managers.DatabaseManager;

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
        return DatabaseManager.getInstance().saveEntry(good);
    }

    @Override
    public Good readGood(Long id)
    {
        return DatabaseManager.getInstance().getEntry(id, Good.class);
    }

    @Override
    public void updateGood(Good good)
    {
        DatabaseManager.getInstance().updateEntry(good);
    }

    @Override
    public void deleteGood(Long id)
    {
        DatabaseManager.getInstance().deleteEntry(id, Good.class);
    }

    @Override
    public List<Good> findAll()
    {
        return DatabaseManager.getInstance().getEntries(Good.class);
    }

    @Override
    public List<Good> findAllStoreGoods()
    {
        List<Good> listAllGoods = DatabaseManager.getInstance().getEntries(Good.class);

        return listAllGoods.stream().filter(good ->
                {
                    return good.getClass().equals(Good.class);
                }).collect(Collectors.toList());
    }

    @Override
    public Good getEntryByField(String fieldName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntryByField(fieldName, fieldValue, Good.class);
    }

    @Override
    public List<Good> getEntriesByField(String fieldName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntriesByField(fieldName, fieldValue, Good.class);
    }
}
