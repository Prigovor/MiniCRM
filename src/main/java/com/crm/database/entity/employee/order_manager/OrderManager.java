package com.crm.database.entity.employee.order_manager;

import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.PositionType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Bohdan on 01.03.2017.
 */
@Entity
@Table(name = "ORDER_MANAGERS")
public class OrderManager extends Employee
{
    public OrderManager()
    {
        setPosition(PositionType.ORDER_MANAGER);
    }
}
