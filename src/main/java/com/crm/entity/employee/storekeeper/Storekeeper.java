package com.crm.entity.employee.storekeeper;

import com.crm.entity.employee.Employee;
import com.crm.entity.employee.PositionType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Bohdan on 24.02.2017.
 */
@Entity
@Table(name = "STOREKEEPERS")
public class Storekeeper extends Employee
{
    public Storekeeper()
    {
        setPosition(PositionType.STOREKEEPER);
    }
}
