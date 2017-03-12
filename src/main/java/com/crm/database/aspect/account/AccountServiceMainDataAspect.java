package com.crm.database.aspect.account;

import com.crm.database.entity.account.Account;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 02.03.2017.
 */
@Aspect
@Component
public class AccountServiceMainDataAspect
{
    @Pointcut("execution(* com.crm.database.service.account.AccountService.saveEntry(*)) && args(account)")
    private void pointcutSaveEntry(Account account)
    {

    }

    @Pointcut("execution(* com.crm.database.service.account.AccountService.saveOrUpdate(*)) && args(account)")
    private void pointcutSaveOrUpdate(Account account)
    {

    }

    @Pointcut("execution(* com.crm.database.service.account.AccountService.updateEntry(*)) && args(account)")
    private void pointcutUpdateEntry(Account account)
    {

    }

    @Before(value = "pointcutSaveEntry(account) || pointcutSaveOrUpdate(account)", argNames = "account")
    private void beforeSave(Account account)
    {

    }

    @Before(value = "pointcutUpdateEntry(account)", argNames = "account")
    private void beforeUpdate(Account account)
    {
    }
}
