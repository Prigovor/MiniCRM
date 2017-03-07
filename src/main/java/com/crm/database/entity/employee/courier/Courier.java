package com.crm.database.entity.employee.courier;

import com.crm.database.entity.employee.Employee;
import com.crm.database.entity.employee.Gender;
import com.crm.database.entity.employee.PositionType;
import com.crm.database.entity.order.Order;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Prigovor on 16.02.2017.
 */
@Entity
@Table(name = "COURIERS")
public class Courier extends Employee
{
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CourierStatus courierStatus;

    @OneToMany(targetEntity = Order.class, cascade = CascadeType.MERGE)
    private List<Order> listOrders;

    public Courier()
    {
        setPosition(PositionType.COURIER);
        setCourierStatus(CourierStatus.FREE);
    }

    public Courier(String name, String surname, Integer age, Gender gender, CourierStatus courierStatus)
    {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
        setPosition(PositionType.COURIER);
        setCourierStatus(CourierStatus.FREE);

        this.courierStatus = courierStatus;
    }

    public CourierStatus getCourierStatus()
    {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus)
    {
        this.courierStatus = courierStatus;
    }

    public List<Order> getListOrders()
    {
        return listOrders;
    }

    public void setListOrders(List<Order> listOrders)
    {
        this.listOrders = listOrders;
    }
}