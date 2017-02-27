package com.crm.managers.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 05.02.2017.
 */
@Repository
public class HibernateDatabaseManager
{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public <PK extends Serializable> PK saveEntry(Object entry)
    {
        return (PK) sessionFactory.getCurrentSession().save(entry);
    }

    @Transactional
    public <T> void saveOrUpdate(T entry)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(entry);
    }

    @Transactional
    public void updateEntry(Object entry)
    {
        sessionFactory.getCurrentSession().update(entry);
    }

    @Transactional
    public<PK extends Serializable> void deleteEntry(PK id, Class entityClass)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(entityClass, id));
    }

    @Transactional
    public <T, PK extends Serializable> T getEntry(PK id, Class<T> entityClass)
    {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Transactional
    public <T, PK extends Serializable> T getEntry(PK id, Class<T> entityClass, Consumer<T> consumer)
    {
        T entry = getEntry(id, entityClass);
        consumer.accept(entry);
        return entry;
    }

    @Transactional
    public <T> List<T> getEntries(Class<T> entityClass)
    {
        return sessionFactory.getCurrentSession().createQuery("From " + entityClass.getName()).list();
    }

    @Transactional
    public <T> List<T> getEntries(Class<T> entityClass, Consumer<T> consumer)
    {
        List<T> list = getEntries(entityClass);
        list.forEach(consumer);
        return list;
    }

    @Transactional
    public <T> List<T> getEntriesByField(String fieldName, Object fieldValue, Class<T> tClass)
    {
        return sessionFactory.getCurrentSession().createCriteria(tClass).add(Restrictions.eq(fieldName, fieldValue)).list();
    }

    @Transactional
    public <T> T getEntryByField(String fieldName, Object fieldValue, Class<T> tClass)
    {
        List<T> list = getEntriesByField(fieldName, fieldValue, tClass);
        return list.isEmpty() ? null : list.get(0);
    }
}
