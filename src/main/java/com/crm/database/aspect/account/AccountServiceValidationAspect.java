package com.crm.database.aspect.account;

import com.crm.database.data.MessageDataContainer;
import com.crm.database.entity.account.Account;
import com.crm.managers.DataValidationManager;
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

    @Before(value = "pointcutSaveEntry(account)", argNames = "account")
    private void beforeSave(Account account)
    {
        if (!DataValidationManager.isLoginValid(account.getLogin()))
        {
            throw new AccountValidationException(MessageDataContainer.LOGIN_INVALID);
        }

        if (!DataValidationManager.isPasswordValid(account.getPassword()))
        {
            throw new AccountValidationException(MessageDataContainer.PASSWORD_INVALID);
        }

        if (!DataValidationManager.isEmailValid(account.getEmail()))
        {
            throw new AccountValidationException(MessageDataContainer.EMAIL_INVALID);
        }

        if (!DataValidationManager.isPhoneValid(account.getPhone()))
        {
            throw new AccountValidationException(MessageDataContainer.PHONE_INVALID);
        }
    }
}
