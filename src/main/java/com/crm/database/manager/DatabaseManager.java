package com.crm.database.manager;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 28.02.2017.
 */
public interface DatabaseManager
{
    <PK extends Serializable> PK saveEntry(Object entry);

    <T> void saveOrUpdate(T entry);

    void updateEntry(Object entry);

    <PK extends Serializable> void deleteEntry(PK id, Class entityClass);

    <T, PK extends Serializable> T getEntry(PK id, Class<T> entityClass);

    <T, PK extends Serializable> T getEntry(PK id, Class<T> entityClass, Consumer<T> consumer);

    <T> List<T> getEntries(Class<T> entityClass);

    <T> List<T> getEntries(Class<T> entityClass, Consumer<T> consumer);

    <T> List<T> getEntriesByField(String fieldName, Object fieldValue, Class<T> tClass);

    <T> T getEntryByField(String fieldName, Object fieldValue, Class<T> tClass);
}
