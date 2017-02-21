package com.crm.service.user;

import com.crm.entity.employee.Employee;
import com.crm.entity.account.Account;
import com.crm.service.UserValidationException;
import com.crm.service.SecureService;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface AccountService extends SecureService
{
    Long createUser(Account account) throws UserValidationException;

    Account readUser(Long id) throws UserValidationException;

    void updateUser(Account account) throws UserValidationException;

    void deleteUser(Long id) throws UserValidationException;

    List<Account> findAll() throws UserValidationException;

    void generateUserFromEmployee(Employee employee) throws UserValidationException, MessagingException;

    void sendPasswordOnEmail(String email) throws UserValidationException, MessagingException;
}
