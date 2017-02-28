package com.crm.database.aspect.account;

import com.crm.database.entity.account.Account;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Bohdan on 28.02.2017.
 */
@Aspect
public class AccountServiceAspect
{
    @Pointcut("execution(* com.crm.database.service.account.AccountService.saveEntry(*)) && args(account)")
    private void pointcutSaveEntry(Account account)
    {

    }

    @Before(value = "pointcutSaveEntry(account)", argNames = "account")
    private void beforeSave(Account account)
    {

    }

    @After(value = "pointcutSaveEntry(account)", argNames = "account")
    private void afterSave(Account account)
    {

    }
}
