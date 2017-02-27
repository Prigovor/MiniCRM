package com.crm.dao.order;

import com.crm.entity.order.Order;
import com.crm.managers.database.HibernateDatabaseManager;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Created by Prigovor on 15.02.2017.
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public Long createOrder(Order order) {
        return HibernateDatabaseManager.getInstance().saveEntry(order);
    }

    @Override
    public Order readOrder(Long id) {
        return HibernateDatabaseManager.getInstance().getEntry(id, Order.class);
    }

    @Override
    public void updateOrder(Order order) {
        HibernateDatabaseManager.getInstance().updateEntry(order);
    }

    @Override
    public void deleteOrder(Long id) {
        HibernateDatabaseManager.getInstance().deleteEntry(id, Order.class);
    }

    @Override
    public List<Order> findAll() {
        return HibernateDatabaseManager.getInstance().getEntries(Order.class);
    }

    @Override
    public Order readOrderEager(Long id)
    {
        return HibernateDatabaseManager.getInstance().getEntry(id, Order.class, order ->
        {
            Hibernate.initialize(order.getGoods());
        });
    }

    @Override
    public List<Order> findAllEager()
    {
        return HibernateDatabaseManager.getInstance().getEntries(Order.class, order ->
        {
            Hibernate.initialize(order.getGoods());
        });
    }
}