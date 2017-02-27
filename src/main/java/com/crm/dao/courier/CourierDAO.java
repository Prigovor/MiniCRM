package com.crm.dao.courier;

import com.crm.entity.courier.Courier;

import java.util.List;

/**
 * Created by Prigovor on 16.02.2017.
 */
public interface CourierDAO {

    Long createCourier(Courier courier);

    Courier readCourier(Long id);

    Courier readCourierEager(Long id);

    void updateCourier(Courier courier);

    void deleteCourier(Long id);

    List<Courier> findAll();

    Courier getEntryByField(String fieldName, Object fieldValue);

    List<Courier> getEntriesByField(String fieldName, Object fieldValue);
}