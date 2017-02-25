package com.crm.entity.selected_good;

import com.crm.entity.good.Good;
import com.crm.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Bohdan on 24.02.2017.
 */
@Entity
@Table(name = "SELECTED_GOODS")
public class SelectedGood extends Good
{
    @ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
    private transient Order order;

    public SelectedGood()
    {
    }

    public SelectedGood(String nomination, int amount, Double price, Order order)
    {
        setNomination(nomination);
        setAmount(amount);
        setPrice(price);

        this.order = order;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
