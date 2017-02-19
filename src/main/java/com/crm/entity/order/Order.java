package com.crm.entity.order;

import com.crm.entity.client.Client;
import com.crm.entity.courier.Courier;
import com.crm.entity.good.Good;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DELIVERY_TIME")
    private Date deliveryTime;

    @Column(name = "ADDRESS")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURIER_ID", referencedColumnName = "ID")
    private Courier courier;

    @Transient
    private List<Good> goods;

    @Column(name = "ORDER_PRICE")
    private Double orderPrice;

    public Order() {
    }

    public Order(Client client, Date registrationDate, Date deliveryTime, String address, OrderStatus orderStatus, List<Good> goods, Double orderPrice) {
        this.client = client;
        this.registrationDate = registrationDate;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.orderStatus = orderStatus;
        this.goods = goods;
        this.orderPrice = orderPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Courier getCourier()
    {
        return courier;
    }

    public void setCourier(Courier courier)
    {
        this.courier = courier;
    }
}
