package com.crm.service.good;

import com.crm.dao.good.GoodDAO;
import com.crm.dao.good.GoodDAOImpl;
import com.crm.entity.good.Good;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public class GoodServiceImpl implements GoodService {

    private GoodDAO goodDAO = new GoodDAOImpl();

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
}