package com.crm.database.entity.good;

import com.crm.database.entity.good.selected_good.SelectedGood;

import javax.persistence.*;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity(name = "GOODS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Good() {
    }

    public Good(String nomination, Integer amount, Double price) {
        this.nomination = nomination;
        this.amount = amount;
        this.price = price;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || (!o.getClass().equals(Good.class) && !o.getClass().equals(SelectedGood.class)))
        {
            return false;
        }

        Good good = (Good) o;

        return nomination != null ? nomination.equals(good.nomination) : good.nomination == null;
    }

    @Override
    public int hashCode()
    {
        return nomination != null ? nomination.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return nomination +
                ", amount=" + amount +
                ", price=" + price;
    }
}