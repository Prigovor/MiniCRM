package com.crm.dao.account;

import com.crm.entity.account.Account;
import com.crm.managers.database.HibernateDatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public class AccountDAOImpl implements AccountDAO
{
    @Override
    public Long createAccount(Account account)
    {
        return HibernateDatabaseManager.getInstance().saveEntry(account);
    }

    @Override
    public Account readAccount(Long id)
    {
        return HibernateDatabaseManager.getInstance().getEntry(id, Account.class);
    }

    @Override
    public void updateAccount(Account account)
    {
        HibernateDatabaseManager.getInstance().updateEntry(account);
    }

    @Override
    public void deleteAccount(Long id)
    {
        HibernateDatabaseManager.getInstance().deleteEntry(id, Account.class);
    }

    @Override
    public List<Account> findAll()
    {
        return HibernateDatabaseManager.getInstance().getEntries(Account.class);
    }

    @Override
    public Account getAccountByField(String filedName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntryByField(filedName, fieldValue, Account.class);
    }

    @Override
    public List<Account> getAccountsByField(String filedName, Object fieldValue)
    {
        return HibernateDatabaseManager.getInstance().getEntriesByField(filedName, fieldValue, Account.class);
    }
}
