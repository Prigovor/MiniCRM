package com.crm.entity.good;

import com.crm.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity
@Table(name = "GOODS")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "good_seq")
    @SequenceGenerator(name = "good_seq", sequenceName = "good_id", allocationSize = 1)
    private Long id;

    @Column(name = "NOMINATION")
    private String nomination;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Order order;

    public Good() {
    }

    public Good(String nomination, Integer amount, Double price, Order order) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}