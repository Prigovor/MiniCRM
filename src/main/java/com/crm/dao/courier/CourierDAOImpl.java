package com.crm.dao.courier;

import com.crm.entity.courier.Courier;
import com.crm.managers.database.HibernateDatabaseManager;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Created by Prigovor on 16.02.2017.
 */
public class CourierDAOImpl implements CourierDAO
{
    @Override
    public Long createCourier(Courier courier)
    {
        return HibernateDatabaseManager.getInstance().saveEntry(courier);
    }

    @Override
    public Courier readCourier(Long id)
    {
        return HibernateDatabaseManager.getInstance().getEntry(id, Courier.class);
    }

    @Override
    public Courier readCourierEager(Long id)
    {
        return HibernateDatabaseManager.getInstance().getEntry(id, Courier.class, courier ->
        {
            Hibernate.initialize(courier.getListOrders());
        });
    }

    @Override
    public void updateCourier(Courier courier)
    {
        HibernateDatabaseManager.getInstance().updateEntry(courier);
    }

    @Override
    public void deleteCourier(Long id)
    {
        HibernateDatabaseManager.getInstance().deleteEntry(id, Courier.class);
    }

    @Override
    public List<Courier> findAll()
    {
        return HibernateDatabaseManager.getInstance().getEntries(Courier.class);
    }

    @Override
    public Courier getEntryByField(String fieldName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntryByField(fieldName, fieldValue, Courier.class);
    }

    @Override
    public List<Courier> getEntriesByField(String fieldName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntriesByField(fieldName, fieldValue, Courier.class);
    }
}