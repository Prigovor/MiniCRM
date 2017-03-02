package com.crm.database.aspect.account;

import com.crm.database.entity.account.Account;
import com.crm.database.manager.PasswordManager;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 02.03.2017.
 */
@Aspect
@Component
public class AccountServicePasswordAspect
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

    @Before(value = "pointcutSaveEntry(account) || pointcutSaveOrUpdate(account) || pointcutUpdateEntry(account)", argNames = "account")
    private void beforeSave(Account account)
    {
        account.setPassword(PasswordManager.getInstance().getEncryptedPassword(account.getPassword()));
    }
}
