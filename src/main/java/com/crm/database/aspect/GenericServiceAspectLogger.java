package com.crm.database.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Bohdan on 01.03.2017.
 */
@Aspect
@Component
public class GenericServiceAspectLogger
{
    private static final Logger logger = LoggerFactory.getLogger(GenericServiceAspectLogger.class);

    @Pointcut("execution (* com.crm.database.service.GenericServiceImpl.*(..))")
    private void pointcutMethodExecution()
    {

    }

    @Before("pointcutMethodExecution()")
    private void beforeExecution(JoinPoint joinPoint)
    {
        logger.info("Entering:\n\t{} with arguments {}",
                joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointcutMethodExecution()")
    private void afterExecution(JoinPoint joinPoint)
    {
        logger.info("Leaving:\n\t{} with arguments {}",
            joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointcutMethodExecution()", throwing = "exc")
    private void afterThrowing(JoinPoint joinPoint, Throwable exc)
    {
        logger.error("Exception was thrown in:\n\t{} stack trace is: {}",
                joinPoint.getSignature(), exc.getStackTrace());
    }

    @AfterReturning(value = "pointcutMethodExecution()", returning = "obj")
    private void afterReturning(JoinPoint joinPoint, Object obj)
    {
        logger.info("Value was returned in:\n\t{} value is: {}",
                joinPoint.getSignature(), obj);
    }
}
