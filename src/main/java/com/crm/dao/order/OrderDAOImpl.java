package com.crm.dao.order;

import com.crm.entity.order.Order;
import com.crm.managers.DatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 15.02.2017.
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public Long createOrder(Order order) {
        return DatabaseManager.getInstance().saveEntry(order);
    }

    @Override
    public Order readOrder(Long id) {
        return DatabaseManager.getInstance().getEntry(id, Order.class);
    }

    @Override
    public void updateOrder(Order order) {
        DatabaseManager.getInstance().updateEntry(order);
    }

    @Override
    public void deleteOrder(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, Order.class);
    }

    @Override
    public List<Order> findAll() {
        return DatabaseManager.getInstance().getEntries(Order.class);
    }
}