package com.crm.database.aspect.account;

import com.crm.database.entity.account.Account;
import com.crm.managers.DataValidationManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 01.03.2017.
 */
@Aspect
@Component
public class AccountServiceAspect
{
    @Pointcut("execution(* com.crm.database.service.account.AccountService.saveEntry(*)) && args(account)")
    private void pointcutSaveEntry(Account account)
    {

    }

    @Before(value = "pointcutSaveEntry(account)", argNames = "account")
    private void beforeSave(Account account)
    {
        if (!DataValidationManager.isLoginValid(account.getLogin()))
        {

        }

        if (!DataValidationManager.isPasswordValid(account.getPassword()))
        {

        }

        if (!DataValidationManager.isEmailValid(account.getEmail()))
        {

        }

        if (!DataValidationManager.isPhoneValid(account.getPhone()))
        {

        }
    }

    @After(value = "pointcutSaveEntry(account)", argNames = "account")
    private void afterSave(Account account)
    {

    }
}
