package com.crm.database.entity.account;

import com.crm.database.entity.employee.Employee;
import com.crm.database.manager.PasswordManager;
import com.crm.database.validation.login.LoginCustom;
import com.crm.database.validation.password.PasswordCustom;
import com.crm.database.validation.unique.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Unique
    @LoginCustom
    @Column(name = "LOGIN")
    private String login;

    @Unique
    @PasswordCustom
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @OneToOne(targetEntity = Employee.class, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID", nullable = false)
    private Employee employee;

    @NotNull(message = "Account rights should be set")
    @Enumerated(EnumType.STRING)
    @Column(name = "RIGHT_TYPE")
    private RightType rightType;

    @NotNull(message = "Account lock type should be set")
    @Enumerated(EnumType.STRING)
    @Column(name = "LOCK_TYPE")
    private LockType lockType;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    public Account()
    {
    }

    public Account(String password, Employee employee, RightType rightType, LockType lockType)
    {
        this.password = password;
        this.employee = employee;
        this.rightType = rightType;
        this.lockType = lockType;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
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

    public String getEmail()
    {
        return employee.getEmail();
    }

    public String getPhone()
    {
        return employee.getPhone();
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public RightType getRightType()
    {
        return rightType;
    }

    public void setRightType(RightType rightType)
    {
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
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (rightType != null ? rightType.hashCode() : 0);
        result = 31 * result + (lockType != null ? lockType.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }
}
