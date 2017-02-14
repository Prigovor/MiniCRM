package com.crm.entity.client;

import javax.persistence.*;

/**
 * Created by Prigovor on 14.02.2017.
 */

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private Long phone;

    @Column(name = "EMAIL")
    private String email;

    public Client() {
    }

    public Client(String name, String surname, Long phone, String email) {
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Сущность для БД
     * Поля: Id, Имя, Фамилия, Номер телефона, Эл. почта
     *
     * Также создать DAO и Service (см. примеры реализации уже существующих,
     * НЕ реализовывать интерфейс SecureService)
     */
}
