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
    private String nomination ;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "PRICE")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Order order;

    public Good() {
    }

    public Good(Long id, String nomination, Long amount, Long price, Order order) {
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return nomination;
    }

    /**
     * Сущность для БД
     * Поля: Id, Наименование, Количество, Цена
     *
     * Также создать DAO и Service (см. примеры реализации уже существующих,
     * НЕ реализовывать интерфейс SecureService)
     */
}
