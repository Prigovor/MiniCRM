package com.crm.service.courier;

import com.crm.dao.courier.CourierDAO;
import com.crm.dao.courier.CourierDAOImpl;
import com.crm.entity.courier.Courier;

import java.util.List;

/**
 * Created by Prigovor on 16.02.2017.
 */
public class CourierServiceImpl implements CourierService {

    private CourierDAO courierDAO = new CourierDAOImpl();

    @Override
    public Long createCourier(Courier courier) {
        return courierDAO.createCourier(courier);
    }

    @Override
    public Courier readCourier(Long id) {
        return courierDAO.readCourier(id);
    }

    @Override
    public void updateCourier(Courier courier) {
        courierDAO.updateCourier(courier);
    }

    @Override
    public void deleteCourier(Long id) {
        courierDAO.deleteCourier(id);
    }

    @Override
    public List<Courier> findAll() {
        return courierDAO.findAll();
    }
}