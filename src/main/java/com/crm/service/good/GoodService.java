package com.crm.service.good;

import com.crm.entity.good.Good;

import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */
public interface GoodService {

    Long createGood(Good good);

    Good readGood(Long id);

    void updateGood(Good good);

    void deleteGood(Long id);

    List<Good> findAll();

    Good getEntryByField(String fieldName, Object fieldValue);

    List<Good> getEntriesByField(String fieldName, Object fieldValue);
}
