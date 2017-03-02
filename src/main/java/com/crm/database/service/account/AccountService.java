package com.crm.database.service.account;

import com.crm.database.entity.account.Account;
import com.crm.database.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Bohdan on 08.02.2017.
 */
@Service
public class AccountService extends GenericServiceImpl<Account, Long>
{
    public Long saveEntry(Account entry)
    {
        return super.saveEntry(entry);
    }

    @Override
    public void saveOrUpdate(Account entry)
    {
        super.saveOrUpdate(entry);
    }

    @Override
    public void updateEntry(Account entry)
    {
        super.updateEntry(entry);
    }
}
