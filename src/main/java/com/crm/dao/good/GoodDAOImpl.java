package com.crm.dao.good;

import com.crm.entity.good.Good;
import com.crm.managers.DatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class GoodDAOImpl implements GoodDAO{
    @Override
    public Long createGood(Good good) {
        return DatabaseManager.getInstance().saveEntry(good);
    }

    @Override
    public Good readGood(Long id) {
        return DatabaseManager.getInstance().getEntry(id, Good.class);
    }

    @Override
    public void updateGood(Good good) {
        DatabaseManager.getInstance().updateEntry(good);
    }

    @Override
    public void deleteGood(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, Good.class);
    }

    @Override
    public List<Good> findAll() {
        return DatabaseManager.getInstance().getEntries(Good.class);    }
}
