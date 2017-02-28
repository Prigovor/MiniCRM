package com.crm.database.dao.hibernate;

import com.crm.database.dao.GenericDao;
import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.manager.FactoryDatabaseManager;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 27.02.2017.
 */
@Repository(value = "hibernateDao")
public class HibernateDao<T, PK extends Serializable> implements GenericDao<T, PK>
{
    private Class<T> tClass;

    public HibernateDao(Class<T> tClass)
    {
        this.tClass = tClass;
    }

    public PK saveEntry(T entry)
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(T entry)
    {
        FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).saveOrUpdate(entry);
    }

    public void updateEntry(T entry)
    {
        FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).updateEntry(entry);
    }

    public void deleteEntry(PK id)
    {
        FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).deleteEntry(id, tClass);
    }

    public T getEntry(PK id)
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntry(id, tClass);
    }

    public T getEntry(PK id, Consumer<T> consumer)
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntry(id, tClass, consumer);
    }

    public List<T> getEntries()
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntries(tClass);
    }

    public List<T> getEntries(Consumer<T> consumer)
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntries(tClass, consumer);
    }

    public T getEntryByField(String fieldName, Object fieldValue)
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntryByField(fieldName, fieldValue, tClass);
    }

    public List<T> getEntriesByField(String fieldName, Object fieldValue)
    {
        return FactoryDatabaseManager.getDatabaseManager(DatabaseManagerType.HIBERNATE).getEntriesByField(fieldName, fieldValue, tClass);
    }
}
