package com.crm.dao.courier;

import com.crm.entity.employee.courier.Courier;
import com.crm.managers.DatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 16.02.2017.
 */
public class CourierDAOImpl implements CourierDAO {
    @Override
    public Long createCourier(Courier courier) {
        return DatabaseManager.getInstance().saveEntry(courier);
    }

    @Override
    public Courier readCourier(Long id) {
        return DatabaseManager.getInstance().getEntry(id, Courier.class);
    }

    @Override
    public void updateCourier(Courier courier) {
        DatabaseManager.getInstance().updateEntry(courier);
    }

    @Override
    public void deleteCourier(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, Courier.class);
    }

    @Override
    public List<Courier> findAll() {
        return DatabaseManager.getInstance().getEntries(Courier.class);
    }

    @Override
    public Courier getEntryByField(String fieldName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntryByField(fieldName, fieldValue, Courier.class);
    }

    @Override
    public List<Courier> getEntriesByField(String fieldName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntriesByField(fieldName, fieldValue, Courier.class);
    }
}