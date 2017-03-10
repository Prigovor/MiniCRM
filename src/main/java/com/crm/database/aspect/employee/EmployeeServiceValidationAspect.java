package com.crm.database.aspect.employee;

import com.crm.database.entity.employee.Employee;
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
public class EmployeeServiceValidationAspect
{
    @Pointcut("execution(* com.crm.database.service.employee.EmployeeService.saveEntry(*)) && args(employee)")
    private void pointcutSaveEntry(Employee employee)
    {

    }

    @Pointcut("execution(* com.crm.database.service.employee.EmployeeService.saveOrUpdate(*)) && args(employee)")
    private void pointcutSaveOrUpdate(Employee employee)
    {

    }

    @Pointcut("execution(* com.crm.database.service.employee.EmployeeService.updateEntry(*)) && args(employee)")
    private void pointcutUpdateEntry(Employee employee)
    {

    }

    @Before(value = "pointcutSaveEntry(employee) || pointcutSaveOrUpdate(employee) || pointcutUpdateEntry(employee)", argNames = "employee")
    private void beforeSave(Employee employee)
    {
        validateEmployee(employee);
    }

    private void validateEmployee(Employee employee)
    {
        EntityValidator.getInstance().validateEntry(employee);
    }
}
