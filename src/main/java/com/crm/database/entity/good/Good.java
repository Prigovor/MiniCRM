package com.crm.database.entity.good;

import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.validation.unique.Unique;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity(name = "GOODS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Good
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Unique
    @NotBlank
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Range(message = "Amount should be bigger than 0", min = 0)
    @Column(name = "AMOUNT")
    private Integer amount;

    @Range(message = "Price should be bigger than 0", min = 0)
    @Column(name = "PRICE")
    private Double price;

    public Good()
    {
    }

    public Good(String name, Integer amount, Double price)
    {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String nomination)
    {
        this.name = nomination;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Double getPrice()
    {
        price = (double) Math.round(price * 100);

        price = price / 100;

        return price;
    }

    public void setPrice(Double price)
    {
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

        return name != null ? name.equals(good.name) : good.name == null;
    }

    @Override
    public int hashCode()
    {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return name +
                ", amount=" + amount +
                ", price=" + price;
    }
}