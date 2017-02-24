package com.crm.dao.order;

import com.crm.entity.order.Order;
import com.crm.managers.DatabaseManager;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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

    @Override
    public Order readOrderEager(Long id)
    {
        Order entry = null;

        try (Session session = DatabaseManager.getInstance().getSessionFactory().getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                entry = session.get(Order.class, id);

                Hibernate.initialize(entry.getGoods());

                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return entry;
    }

    @Override
    public List<Order> findAllEager()
    {
        List<Order> list = null;
        try (Session session = DatabaseManager.getInstance().getSessionFactory().getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                list = session.createQuery("From " + Order.class.getName()).list();

                list.forEach(order ->
                {
                    Hibernate.initialize(order.getGoods());
                });

                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return list;
    }
}