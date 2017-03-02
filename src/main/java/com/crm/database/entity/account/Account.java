package com.crm.database.entity.account;

import com.crm.database.entity.employee.Employee;

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

    @Column(name = "PHONE")
    private String phone;

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

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
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

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null)
        {
            return false;
        }
        if (login != null ? !login.equals(account.login) : account.login != null)
        {
            return false;
        }
        if (password != null ? !password.equals(account.password) : account.password != null)
        {
            return false;
        }
        if (email != null ? !email.equals(account.email) : account.email != null)
        {
            return false;
        }
        if (employee != null ? !employee.equals(account.employee) : account.employee != null)
        {
            return false;
        }
        if (rightType != account.rightType)
        {
            return false;
        }
        if (lockType != account.lockType)
        {
            return false;
        }
        return registrationDate != null ? registrationDate.equals(account.registrationDate) : account.registrationDate == null;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (rightType != null ? rightType.hashCode() : 0);
        result = 31 * result + (lockType != null ? lockType.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }
}
