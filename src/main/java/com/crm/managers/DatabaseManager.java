package com.crm.managers;

import com.crm.entity.client.Client;
import com.crm.entity.employee.Employee;
import com.crm.entity.good.Good;
import com.crm.entity.order.Order;
import com.crm.entity.user.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Bohdan on 05.02.2017.
 */
public final class DatabaseManager
{
    private static DatabaseManager instance;

    public static DatabaseManager getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseManager();

            DatabaseManager.getInstance().configure("hibernate.cfg.xml", User.class, Employee.class, Client.class, Good.class, Order.class);
        }
        return instance;
    }

    private DatabaseManager()
    {

    }

    private SessionFactory sessionFactory;

    public void configure(String configFilePath, Class ...annotatedClasses)
    {
        Configuration configuration = new Configuration().configure(configFilePath);

        for (Class annotatedClass : annotatedClasses)
        {
            configuration.addAnnotatedClass(annotatedClass);
        }

        sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public Long saveEntry(Object entry)
    {
        Long id = 0L;

        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                id = (Long) session.save(entry);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return id;
    }

    public void updateEntry(Object entry)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                session.update(entry);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }
    }

    public void deleteEntry(Long id, Class entityClass)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                session.delete(session.load(entityClass, id));
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }
    }

    public <T> T getEntry(Long id, Class<T> entityClass)
    {
        T entry = null;

        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                entry = session.get(entityClass, id);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return entry;
    }

    public <T> List<T> getEntries(Class<T> entityClass)
    {
        List<T> list = null;
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                list = session.createQuery("From " + entityClass.getName()).list();
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return list;
    }

    /**
     * Метод возвращает список обьектов, отобранных из таблицы по заданному значению поля
     *
     * @param fieldName - фактическое имя поля, по которому будем получать значения
     * @param fieldValue - искомое значение поля
     * @param tClass - класс, с которым взаимодействуем
     * @param <T> - тип класса
     * @return список отобранных значений
     */
    public <T> List<T> getEntriesByField(String fieldName, Object fieldValue, Class<T> tClass)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            return session.createCriteria(tClass).add(Restrictions.eq(fieldName, fieldValue)).list();
        }
    }

    /**
     * Метод возвращает один обьект, выбранный из таблицы по заданному значению поля
     *
     * @param fieldName - фактическое имя поля, по которому будем получать значения
     * @param fieldValue - искомое значение поля
     * @param tClass - класс, с которым взаимодействуем
     * @param <T> - тип класса
     * @return найденный обьект
     */
    public <T> T getEntryByField(String fieldName, Object fieldValue, Class<T> tClass)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            return (T) session.createCriteria(tClass).add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
        }
    }
}
