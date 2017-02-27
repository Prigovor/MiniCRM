package com.crm.service;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Bohdan on 27.02.2017.
 */
public interface GenericService<T, PK extends Serializable>
{
    PK saveEntry(T entry);

    void saveOrUpdate(T entry);

    void updateEntry(T entry);

    void deleteEntry(PK id);

    T getEntry(PK id);

    T getEntry(PK id, Consumer<T> consumer);

    List<T> getEntries();

    List<T> getEntries(Consumer<T> consumer);

    T getEntryByField(String fieldName, Object fieldValue);

    List<T> getEntriesByField(String fieldName, Object fieldValue);
}
