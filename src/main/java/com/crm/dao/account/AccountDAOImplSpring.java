package com.crm.dao.account;

import com.crm.entity.account.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Bohdan on 25.02.2017.
 */
@Repository
public class AccountDAOImplSpring implements AccountDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Long createAccount(Account account)
    {
        return (Long) sessionFactory.getCurrentSession().save(account);
    }

    @Override
    public Account readAccount(Long id)
    {
        return null;
    }

    @Override
    public void updateAccount(Account account)
    {

    }

    @Override
    public void deleteAccount(Long id)
    {

    }

    @Override
    public List<Account> findAll()
    {
        return null;
    }

    @Override
    public List<Account> getAccountsByField(String filedName, Object fieldValue)
    {
        return null;
    }

    @Override
    public Account getAccountByField(String filedName, Object fieldValue)
    {
        return null;
    }
}
