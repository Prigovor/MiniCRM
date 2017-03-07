package com.crm.database.entity.employee;

import com.crm.database.entity.account.Account;
import com.crm.database.service.employee.EmployeeService;
import com.crm.database.validation.email.EmailCustom;
import com.crm.database.validation.phone.PhoneCustom;
import com.crm.database.validation.unique.Unique;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Prigovor on 05.02.2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "EMPLOYEES")
public class Employee
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Employee name should be set")
    @Column(name = "NAME")
    private String name;

    @NotBlank(message = "Employee surname should be set")
    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private Integer age;

    @NotNull(message = "Employee gender should be set")
    @Column(name = "GENDER")
    private Gender gender;

    @NotNull(message = "Employee position should be set")
    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION")
    private PositionType position;

    @Unique
    @PhoneCustom
    @Column(name = "PHONE")
    private String phone;

    @Unique
    @EmailCustom
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

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null)
        {
            return false;
        }
        if (name != null ? !name.equals(employee.name) : employee.name != null)
        {
            return false;
        }
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null)
        {
            return false;
        }
        if (age != null ? !age.equals(employee.age) : employee.age != null)
        {
            return false;
        }
        if (gender != employee.gender)
        {
            return false;
        }
        if (position != employee.position)
        {
            return false;
        }
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null)
        {
            return false;
        }
        return email != null ? email.equals(employee.email) : employee.email == null;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return name + " " + surname + " (" + email + ")";
    }
}
