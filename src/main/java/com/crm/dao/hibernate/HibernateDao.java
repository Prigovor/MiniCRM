package com.crm.dao.hibernate;

import com.crm.dao.GenericDao;
import com.crm.managers.database.DatabaseManagerFactory;
import com.crm.managers.database.DatabaseManagerType;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class HibernateDao<T, PK extends Serializable> implements GenericDao<T, PK>
{
    private Class<T> tClass;

    public HibernateDao(Class<T> tClass)
    {
        this.tClass = tClass;
    }

    public PK saveEntry(T entry)
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(T entry)
    {
        DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).saveOrUpdate(entry);
    }

    public void updateEntry(T entry)
    {
        DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).updateEntry(entry);
    }

    public void deleteEntry(PK id)
    {
        DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).deleteEntry(id, tClass);
    }

    public T getEntry(PK id)
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntry(id, tClass);
    }

    public T getEntry(PK id, Consumer<T> consumer)
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntry(id, tClass, consumer);
    }

    public List<T> getEntries()
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntries(tClass);
    }

    public List<T> getEntries(Consumer<T> consumer)
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntries(tClass, consumer);
    }

    public T getEntryByField(String fieldName, Object fieldValue)
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntryByField(fieldName, fieldValue, tClass);
    }

    public List<T> getEntriesByField(String fieldName, Object fieldValue)
    {
        return DatabaseManagerFactory.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntriesByField(fieldName, fieldValue, tClass);
    }
}
