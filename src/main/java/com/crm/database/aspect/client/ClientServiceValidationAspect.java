package com.crm.database.aspect.client;

import com.crm.database.entity.client.Client;
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

    @Pointcut("execution(* com.crm.database.service.client.ClientService.updateEntry(*)) && args(client)")
    private void pointcutSaveOrUpdateEntry(Client client)
    {

    }

    @Pointcut("execution(* com.crm.database.service.client.ClientService.saveOrUpdate(*)) && args(client)")
    private void pointcutUpdateEntry(Client client)
    {

    }

    @Before(value = "pointcutSaveEntry(client) || pointcutSaveOrUpdateEntry(client) || pointcutUpdateEntry(client)", argNames = "client")
    private void beforeSave(Client client)
    {
        validateClient(client);
    }

    private void validateClient(Client client)
    {
    }
}
