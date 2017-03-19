package com.crm.database.entity.good.selected_good;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.order.Order;

import javax.persistence.*;

/**
 * Created by Bohdan on 24.02.2017.
 */
@Entity
@Table(name = "SELECTED_GOODS")
public class SelectedGood extends Good
{
    @ManyToOne(targetEntity = Order.class)
    private Order order;

    @OneToOne
    @JoinColumn(name = "STORE_GOOD_ID")
    private Good goodInStore;

    public SelectedGood()
    {
    }

    public SelectedGood(Good goodInStore, Order order)
    {
        setGoodInStore(goodInStore);
        setAmount(0);

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

    public Good getGoodInStore()
    {
        return goodInStore;
    }

    public void setGoodInStore(Good goodInStore)
    {
        this.goodInStore = goodInStore;

        setName(goodInStore.getName());
        setDescription(goodInStore.getDescription());
        setPrice(goodInStore.getPrice());
    }

    public void incAmount()
    {
        if (goodInStore.getAmount() > 0)
        {
            setAmount(getAmount() + 1);
            goodInStore.setAmount(goodInStore.getAmount() - 1);
        }
    }

    public void decAmount()
    {
        if (getAmount() > 0)
        {
            setAmount(getAmount() - 1);
            goodInStore.setAmount(goodInStore.getAmount() + 1);
        }
    }
}
