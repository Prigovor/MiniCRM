package com.crm.service.good;

import com.crm.dao.FactoryDAO;
import com.crm.dao.good.GoodDAO;
import com.crm.entity.good.Good;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class GoodServiceImpl implements GoodService {

    private GoodDAO goodDAO = FactoryDAO.getGoodDAO();

    @Override
    public Long createGood(Good good) {
        return goodDAO.createGood(good);
    }

    @Override
    public Good readGood(Long id) {
        return goodDAO.readGood(id);
    }

    @Override
    public void updateGood(Good good) {
        goodDAO.updateGood(good);
    }

    @Override
    public void deleteGood(Long id) {
        goodDAO.deleteGood(id);
    }

    @Override
    public List<Good> findAll() {
        return goodDAO.findAll();
    }


    @Override
    public Good getEntryByField(String fieldName, Object fieldValue)
    {
        return goodDAO.getEntryByField(fieldName, fieldValue);
    }

    @Override
    public List<Good> getEntriesByField(String fieldName, Object fieldValue)
    {
        return goodDAO.getEntriesByField(fieldName, fieldValue); 
    }
}