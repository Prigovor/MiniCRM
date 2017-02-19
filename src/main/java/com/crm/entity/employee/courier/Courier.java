package com.crm.entity.employee.courier;

import com.crm.entity.employee.Employee;
import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;
import com.crm.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Prigovor on 16.02.2017.
 */
@Entity(name = "COURIERS")
public class Courier extends Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CourierStatus courierStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Courier()
    {
    }

    public Courier(String name, String surname, Integer age, Gender gender, CourierStatus courierStatus, Order order)
    {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
        setPosition(PositionType.COURIER);

        this.courierStatus = courierStatus;
        this.order = order;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public CourierStatus getCourierStatus()
    {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus)
    {
        this.courierStatus = courierStatus;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    /**
     * Курьер занимается доставкой заказа.
     *
     * Поля: Имя, фамилия, статус (занят, свободен), заказ
     *
     * Реализовать DAO, Service (не имплементировать SecureService),
     * добавить DAO в фабрику
     */
}