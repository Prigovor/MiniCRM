package com.crm.database.service;

import com.crm.database.dao.GenericDao;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 27.02.2017.
 */
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK>
{
    protected GenericDao<T, PK> dao;

    public GenericServiceImpl(GenericDao<T, PK> dao)
    {
        this.dao = dao;
    }

    @Override
    public PK saveEntry(T entry)
    {
        return dao.saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(T entry)
    {
        dao.saveOrUpdate(entry);
    }

    @Override
    public void updateEntry(T entry)
    {
        dao.updateEntry(entry);
    }

    @Override
    public void deleteEntry(PK id)
    {
        dao.deleteEntry(id);
    }

    @Override
    public T getEntry(PK id)
    {
        return dao.getEntry(id);
    }

    @Override
    public T getEntry(PK id, Consumer<T> consumer)
    {
        return dao.getEntry(id, consumer);
    }

    @Override
    public List<T> getEntries()
    {
        return dao.getEntries();
    }

    @Override
    public List<T> getEntries(Consumer<T> consumer)
    {
        return dao.getEntries(consumer);
    }

    @Override
    public T getEntryByField(String fieldName, Object fieldValue)
    {
        return dao.getEntryByField(fieldName, fieldValue);
    }

    @Override
    public List<T> getEntriesByField(String fieldName, Object fieldValue)
    {
        return dao.getEntriesByField(fieldName, fieldValue);
    }
}
