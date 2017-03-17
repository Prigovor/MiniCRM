package com.crm.database.aspect.order;

import com.crm.database.entity.order.Order;
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
public class OrderServiceValidationAspect
{
    @Pointcut("execution(* com.crm.database.service.order.OrderService.saveEntry(*)) && args(order)")
    private void pointcutSaveEntry(Order order)
    {

    }

    @Pointcut("execution(* com.crm.database.service.order.OrderService.saveOrUpdate(*)) && args(order)")
    private void pointcutSaveOrUpdate(Order order)
    {

    }

    @Pointcut("execution(* com.crm.database.service.order.OrderService.updateEntry(*)) && args(order)")
    private void pointcutUpdate(Order order)
    {

    }

    @Before(value = "pointcutSaveOrUpdate(order) || pointcutSaveEntry(order) || pointcutUpdate(order)", argNames = "order")
    private void beforeSave(Order order)
    {
        validateOrder(order);
    }

    private void validateOrder(Order order)
    {
        EntityValidator.getInstance().validateEntry(order);
    }
}
