package com.crm.service.account;

import com.crm.dao.GenericDao;
import com.crm.entity.account.Account;
import com.crm.service.GenericServiceImpl;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class AccountServiceImpl extends GenericServiceImpl<Account, Long>
{
    public AccountServiceImpl(GenericDao<Account, Long> dao)
    {
        super(dao);
    }
}
