package com.crm.database.aspect.good;

import com.crm.database.entity.good.Good;
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
public class GoodServiceValidationAspect
{
    @Pointcut("execution(* com.crm.database.service.good.GoodService.saveEntry(*)) && args(good)")
    private void pointcutSaveEntry(Good good)
    {

    }

    @Pointcut("execution(* com.crm.database.service.good.GoodService.saveOrUpdate(*)) && args(good)")
    private void pointcutSaveOrUpdate(Good good)
    {

    }

    @Pointcut("execution(* com.crm.database.service.good.GoodService.updateEntry(*)) && args(good)")
    private void pointcutUpdate(Good good)
    {

    }

    @Before(value = "pointcutSaveOrUpdate(good) || pointcutSaveEntry(good) || pointcutUpdate(good)", argNames = "good")
    private void beforeSave(Good good)
    {
        validateGood(good);
    }

    private void validateGood(Good good)
    {
        EntityValidator.getInstance().validateEntry(good);
    }
}
