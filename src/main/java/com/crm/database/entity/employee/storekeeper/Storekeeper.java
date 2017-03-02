package com.crm.database.entity.employee.storekeeper;

import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.PositionType;

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
