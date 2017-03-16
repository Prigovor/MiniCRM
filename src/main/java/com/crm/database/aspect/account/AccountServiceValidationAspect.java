package com.crm.database.aspect.account;

import com.crm.database.entity.account.Account;
import com.crm.database.validation.EntityValidator;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 01.03.2017.
 */
@Aspect
@Component
public class AccountServiceValidationAspect
{
    @Pointcut("execution(* com.crm.database.service.account.AccountService.saveEntry(*)) && args(account)")
    private void pointcutSaveEntry(Account account)
    {

    }

    @Pointcut("execution(* com.crm.database.service.account.AccountService.updateEntry(*)) && args(account)")
    private void pointcutUpdateEntry(Account account)
    {

    }

    @Pointcut("execution(* com.crm.database.service.account.AccountService.saveOrUpdate(*)) && args(account)")
    private void pointcutSaveOrUpdateEntry(Account account)
    {

    }

    @Before(value = "pointcutSaveEntry(account) || pointcutSaveOrUpdateEntry(account) || pointcutUpdateEntry(account)", argNames = "account")
    private void beforeSave(Account account)
    {
        validateAccount(account);
    }

    private void validateAccount(Account account)
    {
        EntityValidator.getInstance().validateEntry(account);
    }
}
