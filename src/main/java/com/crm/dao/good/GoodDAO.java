package com.crm.dao.good;

import com.crm.entity.good.Good;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public interface GoodDAO {

    Long createGood(Good good);

    Good readGood(Long id);

    void updateGood(Good good);

    void deleteGood(Long id);

    List<Good> findAll();

    List<Good> findAllStoreGoods();

    Good getEntryByField(String fieldName, Object fieldValue);

    List<Good> getEntriesByField(String fieldName, Object fieldValue);
}
