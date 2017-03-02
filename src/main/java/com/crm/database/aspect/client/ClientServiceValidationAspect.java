package com.crm.database.aspect.client;

import com.crm.database.data.MessageDataContainer;
import com.crm.database.entity.client.Client;
import com.crm.managers.DataValidationManager;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Bohdan on 28.02.2017.
 */
@Aspect
@Component
public class ClientServiceValidationAspect
{
    @Pointcut("execution(* com.crm.database.service.client.ClientService.saveEntry(*)) && args(client)")
    private void pointcutSaveEntry(Client client)
    {

    }

    @Before(value = "pointcutSaveEntry(client)", argNames = "client")
    private void beforeSave(Client client)
    {
        if (!DataValidationManager.isLoginValid(client.getLogin()))
        {
            throw new ClientValidationException(MessageDataContainer.LOGIN_INVALID);
        }

        if (!DataValidationManager.isPasswordValid(client.getPassword()))
        {
            throw new ClientValidationException(MessageDataContainer.PASSWORD_INVALID);
        }

        if (!DataValidationManager.isEmailValid(client.getEmail()))
        {
            throw new ClientValidationException(MessageDataContainer.EMAIL_INVALID);
        }

        if (!DataValidationManager.isPhoneValid(client.getPhone()))
        {
            throw new ClientValidationException(MessageDataContainer.PHONE_INVALID);
        }
    }
}
