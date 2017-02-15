package com.crm.entity.order;

import com.crm.entity.client.Client;
import com.crm.entity.good.Good;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_id", allocationSize = 5)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEADLINE")
    private Date deadline;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Good> goods;

    @Column(name = "ORDER_PRICE")
    private Long orderPrice;

    public Order() {
    }

    public Order(Client client, Date registrationDate, Date deadline, OrderStatus orderStatus, Long orderPrice) {
        this.client = client;
        this.registrationDate = registrationDate;
        this.deadline = deadline;
        this.orderStatus = orderStatus;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Сущность для БД
     * Id: создать отличную от Автогенерации стратегию генерации id
     * (пока что любую, на ваше усмотрение)
     *
     * Поля: client, Дата регистрации, Срок выполнения (в днях), Статус заказа, Список товаров, Сумма заказа
     *
     * Также создать DAO и Service (см. примеры реализации уже существующих,
     * НЕ реализовывать интерфейс SecureService)
     */
}
