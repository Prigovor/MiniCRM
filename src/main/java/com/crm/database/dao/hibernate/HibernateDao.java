package com.crm.database.dao.hibernate;

import com.crm.database.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class HibernateDao<T, PK extends Serializable> implements GenericDao<T, PK>
{
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> tClass;

    public HibernateDao(Class<T> tClass)
    {
        this.tClass = tClass;
    }

    @Transactional
    public PK saveEntry(T entry)
    {
        return (PK) sessionFactory.getCurrentSession().save(entry);
    }

    @Transactional
    public void saveOrUpdate(T entry)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(entry);
    }

    @Transactional
    public void updateEntry(T entry)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(entry);
    }

    @Transactional
    public void deleteEntry(PK id)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(tClass, id));
    }

    @Transactional
    public T getEntry(PK id)
    {
        return sessionFactory.getCurrentSession().get(tClass, id);
    }

    @Transactional
    public T getEntry(PK id, Consumer<T> consumer)
    {
        T entry = getEntry(id);
        consumer.accept(entry);
        return entry;
    }

    @Transactional
    public List<T> getEntries()
    {
        return sessionFactory.getCurrentSession().createQuery("From " + tClass.getName()).list();
    }

    @Transactional
    public List<T> getEntries(Consumer<T> consumer)
    {
        List<T> list = getEntries();
        list.forEach(consumer);
        return list;
    }

    @Transactional
    public T getEntryByField(String fieldName, Object fieldValue)
    {
        List<T> list = getEntriesByField(fieldName, fieldValue);
        return list.isEmpty() ? null : list.get(0);
    }

    @Transactional
    public List<T> getEntriesByField(String fieldName, Object fieldValue)
    {
        if (fieldValue == null)
        {
            return sessionFactory.getCurrentSession().createCriteria(tClass).add(Restrictions.isNull(fieldName)).list();
        }
        return sessionFactory.getCurrentSession().createCriteria(tClass).add(Restrictions.eq(fieldName, fieldValue)).list();
    }
}
