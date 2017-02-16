package com.crm.service.courier;

import com.crm.entity.courier.Courier;

import java.util.List;

/**
 * Created by Prigovor on 16.02.2017.
 */
public interface CourierService {

    Long createCourier(Courier courier);

    Courier readCourier(Long id);

    void updateCourier(Courier courier);

    void deleteCourier(Long id);

    List<Courier> findAll();
}
