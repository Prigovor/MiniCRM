package com.crm.service.account;

import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface AccountService
{
    Long createAccount(Account account) throws CreateAccountException;

    Account readAccount(Long id);

    void updateAccount(Account account) throws CreateAccountException;

    void deleteAccount(Long id);

    List<Account> findAll();

    List<Account> getAccountsByField(String filedName, Object fieldValue);

    Account getAccountByField(String filedName, Object fieldValue);

    void generateAccountFromEmployee(Employee employee) throws MessagingException;

    void sendPasswordOnEmail(String email) throws MessagingException;
}
