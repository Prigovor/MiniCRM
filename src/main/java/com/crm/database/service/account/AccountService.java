package com.crm.database.service.account;

import com.crm.database.dao.GenericDao;
import com.crm.database.service.GenericServiceImpl;
import com.crm.database.entity.account.Account;
import org.springframework.stereotype.Service;

/**
 * Created by Bohdan on 08.02.2017.
 */
@Service(value = "accountService")
public class AccountService extends GenericServiceImpl<Account, Long>
{
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
