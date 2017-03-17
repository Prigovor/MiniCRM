package com.crm.database.entity.client;

import com.crm.database.entity.order.Order;
import com.crm.database.manager.PasswordManager;
import com.crm.database.validation.email.EmailCustom;
import com.crm.database.validation.login.LoginCustom;
import com.crm.database.validation.password.PasswordCustom;
import com.crm.database.validation.phone.PhoneCustom;
import com.crm.database.validation.unique.Unique;
import org.hibernate.validator.constraints.NotBlank;

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
    @PasswordCustom
    @Column(name = "PASSWORD")
    private String password;

    @NotBlank(message = "Client name should be filled")
    @Column(name = "NAME")
    private String name;

    @NotBlank(message = "Client surname should be filled")
    @Column(name = "SURNAME")
    private String surname;

    @Unique
    @PhoneCustom
    @Column(name = "PHONE")
    private String phone;

    @Unique
    @EmailCustom
    @Column(name = "EMAIL")
    private String email;

    @OneToMany(targetEntity = Order.class, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "client")
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
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null)
        {
            return false;
        }
        if (password != null ? !password.equals(client.password) : client.password != null)
        {
            return false;
        }
        if (name != null ? !name.equals(client.name) : client.name != null)
        {
            return false;
        }
        if (surname != null ? !surname.equals(client.surname) : client.surname != null)
        {
            return false;
        }
        if (phone != null ? !phone.equals(client.phone) : client.phone != null)
        {
            return false;
        }
        return email != null ? email.equals(client.email) : client.email == null;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + email + ")";
    }
}
