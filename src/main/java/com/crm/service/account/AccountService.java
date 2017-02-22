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
    Long createAccount(Account account);

    Account readAccount(Long id);

    void updateAccount(Account account);

    void deleteAccount(Long id);

    List<Account> findAll();

    void generateAccountFromEmployee(Employee employee) throws MessagingException;

    void sendPasswordOnEmail(String email) throws MessagingException;
}
