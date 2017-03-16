package com.crm.database.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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
        logger.info("Entering: {} with arguments {}",
                joinPoint.getSignature(), Arrays.stream(joinPoint.getArgs())
                        .filter(Objects::nonNull).collect(Collectors.toList()));
    }

    @After("pointcutMethodExecution()")
    private void afterExecution(JoinPoint joinPoint)
    {
        logger.info("Leaving: {} with arguments {}",
                joinPoint.getSignature(), Arrays.stream(joinPoint.getArgs())
                        .filter(Objects::nonNull).collect(Collectors.toList()));
    }

    @AfterThrowing(value = "pointcutMethodExecution()", throwing = "exc")
    private void afterThrowing(JoinPoint joinPoint, Throwable exc)
    {
        logger.error("Exception was thrown in: {} stack trace is: {}",
                joinPoint.getSignature(), exc.getStackTrace());

        exc.printStackTrace();
    }

    @AfterReturning(value = "pointcutMethodExecution()", returning = "obj")
    private void afterReturning(JoinPoint joinPoint, Object obj)
    {
        logger.info("Value was returned in: {} value is: {}",
                joinPoint.getSignature(), obj);
    }
}
