package com.crm.dao.order;

import com.crm.entity.order.Order;

import java.util.List;

/**
 * Created by Prigovor on 15.02.2017.
 */
public interface OrderDAO {

    Long createOrder(Order order);

    Order readOrder(Long id);

    void updateOrder(Order order);

    void deleteOrder(Long id);

    List<Order> findAll();
}