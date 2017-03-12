package com.crm.database.entity.client;

import com.crm.database.entity.order.Order;
import com.crm.database.manager.PasswordManager;
import com.crm.database.validation.email.EmailCustom;
import com.crm.database.validation.login.LoginCustom;
import com.crm.database.validation.password.PasswordCustom;
import com.crm.database.validation.unique.Unique;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Unique
    @LoginCustom
    @Column(name = "LOGIN")
    private String login;

    @Unique
    @PasswordCustom
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private String phone;

    @Unique
    @EmailCustom
    @Column(name = "EMAIL")
    private String email;

    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
    private List<Order> orders;

    public Client() {
    }

    public Client(String name, String surname, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String inputPassword)
    {
        this.password = PasswordManager.getInstance().getEncryptedPassword(inputPassword);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return login;
    }
}
