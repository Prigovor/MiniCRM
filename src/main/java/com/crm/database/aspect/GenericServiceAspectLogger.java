package com.crm.database.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Bohdan on 01.03.2017.
 */
@Aspect
@Component
public class GenericServiceAspectLogger
{
    @Pointcut("execution (* com.crm.database.service.GenericServiceImpl.*(..))")
    private void pointcutMethodExecution()
    {

    }

    @Before("pointcutMethodExecution()")
    private void beforeExecution(JoinPoint joinPoint)
    {
        System.out.println(
                String.format("Entering:\t%s with arguments %s",
                joinPoint.getSignature(),
                Arrays.toString(joinPoint.getArgs()))
        );
    }

    @After("pointcutMethodExecution()")
    private void afterExecution(JoinPoint joinPoint)
    {
        System.out.println(
                String.format("Leaving:\t%s with arguments %s",
                        joinPoint.getSignature(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

    @AfterThrowing(value = "pointcutMethodExecution()", throwing = "exc")
    private void afterThrowing(JoinPoint joinPoint, Throwable exc)
    {

    }

    @AfterReturning(value = "pointcutMethodExecution()", returning = "obj")
    private void afterReturning(JoinPoint joinPoint, Object obj)
    {

    }
}
