package com.crm.dao.account;

import com.crm.entity.account.Account;
import com.crm.managers.DatabaseManager;

import java.util.List;
import java.util.Objects;

/**
 * Created by Prigovor on 05.02.2017.
 */
public class AccountDAOImpl implements AccountDAO
{
    @Override
    public Long createAccount(Account account)
    {
        return DatabaseManager.getInstance().saveEntry(account);
    }

    @Override
    public Account readAccount(Long id)
    {
        return DatabaseManager.getInstance().getEntry(id, Account.class);
    }

    @Override
    public void updateAccount(Account account)
    {
        DatabaseManager.getInstance().updateEntry(account);
    }

    @Override
    public void deleteAccount(Long id)
    {
        DatabaseManager.getInstance().deleteEntry(id, Account.class);
    }

    @Override
    public List<Account> findAll()
    {
        return DatabaseManager.getInstance().getEntries(Account.class);
    }

    @Override
    public List<Account> getAccountsByField(String filedName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntriesByField(filedName, fieldValue, Account.class);
    }

    @Override
    public Account getAccountByField(String filedName, Object fieldValue)
    {
        return DatabaseManager.getInstance().getEntryByField(filedName, fieldValue, Account.class);
    }
}
