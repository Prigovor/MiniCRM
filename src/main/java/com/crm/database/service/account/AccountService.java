package com.crm.database.service.account;

import com.crm.database.dao.GenericDao;
import com.crm.database.entity.account.Account;
import com.crm.database.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bohdan on 08.02.2017.
 */
@Service
public class AccountService extends GenericServiceImpl<Account, Long>
{
    @Autowired
    public AccountService(GenericDao<Account, Long> dao)
    {
        super(dao);
    }

    @Override
    public Long saveEntry(Account entry)
    {
        return super.saveEntry(entry);
    }
}
