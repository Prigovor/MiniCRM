package com.crm.entity.account;

import com.crm.entity.employee.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Prigovor on 05.02.2017.
 */

@Entity
@Table(name = "ACCOUNTS")
public class Account
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "RIGHT_TYPE")
    private RightType rightType;

    @Enumerated(EnumType.STRING)
    @Column(name = "LOCK_TYPE")
    private LockType lockType;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    public Account() {
    }

    public Account(String password, Employee employee, RightType rightType, LockType lockType) {
        this.password = password;
        this.employee = employee;
        this.rightType = rightType;
        this.lockType = lockType;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public RightType getRightType() {
        return rightType;
    }

    public void setRightType(RightType rightType) {
        this.rightType = rightType;
    }

    public LockType getLockType()
    {
        return lockType;
    }

    public void setLockType(LockType lockType)
    {
        this.lockType = lockType;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString()
    {
        return login;
    }
}
