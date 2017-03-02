package com.crm.database.entity.employee;

import com.crm.database.entity.account.Account;

import javax.persistence.*;

/**
 * Created by Prigovor on 05.02.2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "EMPLOYEES")
public class Employee
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "GENDER")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION")
    private PositionType position;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(mappedBy = "employee", targetEntity = Account.class)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private Account account;

    public Employee()
    {
    }

    public Employee(String name, String surname, Integer age, Gender gender, PositionType position)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.position = position;
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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public PositionType getPosition()
    {
        return position;
    }

    public void setPosition(PositionType position)
    {
        this.position = position;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    @Override
    public String toString()
    {
        return id.toString();
    }
}
