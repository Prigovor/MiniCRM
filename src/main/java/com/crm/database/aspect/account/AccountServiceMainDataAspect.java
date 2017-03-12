package com.crm.database.aspect.account;

import com.crm.database.entity.account.Account;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.managers.EmailManager;
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

    @Before(value = "pointcutSaveEntry(account) || pointcutSaveOrUpdate(account) || pointcutUpdateEntry(account)", argNames = "account")
    private void beforeSave(Account account)
    {
        if (FactoryService.getAccountService().getEntryByField("login", account.getLogin()) == null)
        {
            EmailManager.getInstance().sendMessage(account.getEmail(), "Your login from mini.crm account", account.getLogin());
        }

        if (FactoryService.getAccountService().getEntryByField("password", account.getPassword()) == null)
        {
            String generatedPassword = PasswordManager.getInstance().generatePassword(8);

            account.setPassword(generatedPassword);

            EmailManager.getInstance().sendMessage(account.getEmail(), "Your password from mini.crm account", generatedPassword);
        }
    }
}
