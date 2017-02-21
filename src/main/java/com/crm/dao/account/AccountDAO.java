package com.crm.dao.account;

import com.crm.entity.account.Account;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public interface AccountDAO
{
    Long createAccount(Account account);

    Account readAccount(Long id);

    void updateAccount(Account account);

    void deleteAccount(Long id);

    List<Account> findAll();

    List<Account> getAccountsByField(String filedName, Object fieldValue);

    Account getAccountByField(String filedName, Object fieldValue);
}
