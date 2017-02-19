package com.crm.entity.courier;

import com.crm.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Prigovor on 16.02.2017.
 */
@Entity(name = "Courier")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CourierStatus courierStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Courier() {
    }

    public Courier(String name, String surname, CourierStatus courierStatus, Order order) {
        this.name = name;
        this.surname = surname;
        this.courierStatus = courierStatus;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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