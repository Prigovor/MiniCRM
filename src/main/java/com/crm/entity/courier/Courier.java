package com.crm.entity.courier;

import com.crm.entity.employee.Employee;
import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;

import javax.persistence.*;

/**
 * Created by Prigovor on 16.02.2017.
 */
@Entity
@Table(name = "COURIER")
public class Courier extends Employee
{
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CourierStatus courierStatus;

    public Courier() {
        setPosition(PositionType.COURIER);
        setCourierStatus(CourierStatus.FREE);
    }

    public Courier(String name, String surname, Integer age, Gender gender, CourierStatus courierStatus) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
        setPosition(PositionType.COURIER);
        setCourierStatus(CourierStatus.FREE);

        this.courierStatus = courierStatus;
    }

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    @Override
    public String toString()
    {
        return getName() + " " + getSurname();
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