package com.crm.service.order;

import com.crm.dao.order.OrderDAO;
import com.crm.dao.order.OrderDAOImpl;
import com.crm.entity.order.Order;

import java.util.List;

/**
 * Created by Prigovor on 15.02.2017.
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public Long createOrder(Order order) {
        return orderDAO.createOrder(order);
    }

    @Override
    public Order readOrder(Long id) {
        return orderDAO.readOrder(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }
}