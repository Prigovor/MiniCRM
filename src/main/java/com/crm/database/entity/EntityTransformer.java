package com.crm.database.entity;

import com.crm.database.entity.employee.Employee;

/**
 * Created by Bohdan on 07.03.2017.
 */
public class EntityTransformer
{
    public static <C extends Employee> C getTransformedEmployee(C objFrom, C objTo)
    {
        objTo.setId(objFrom.getId());
        objTo.setName(objFrom.getName());
        objTo.setSurname(objFrom.getSurname());
        objTo.setEmail(objFrom.getEmail());
        objTo.setPhone(objFrom.getPhone());
        objTo.setAge(objFrom.getAge());
        objTo.setGender(objFrom.getGender());

        objTo.setAccount(objFrom.getAccount());

        return objTo;
    }
}
