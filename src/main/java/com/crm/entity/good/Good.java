package com.crm.entity.good;

import com.crm.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity
@Table(name = "GOOD")
public class Good {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMINATION")
    private String nomination;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Order order;

    public Good() {
    }

    public Good(Long id, String nomination, Integer amount, Double price, Order order) {
        this.id = id;
        this.nomination = nomination;
        this.amount = amount;
        this.price = price;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Good good = (Good) o;

        return id != null ? id.equals(good.id) : good.id == null;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return nomination + " " + amount;
    }

    /**
     * Сущность для БД
     * Поля: Id, Наименование, Количество, Цена
     *
     * Также создать DAO и Service (см. примеры реализации уже существующих,
     * НЕ реализовывать интерфейс SecureService)
     */
}
