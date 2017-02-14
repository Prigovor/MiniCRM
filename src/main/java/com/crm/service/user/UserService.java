package com.crm.service.user;

import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.service.UserValidationException;
import com.crm.service.SecureService;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface UserService extends SecureService
{
    Long createUser(User user) throws UserValidationException;

    User readUser(Long id) throws UserValidationException;

    void updateUser(User user) throws UserValidationException;

    void deleteUser(Long id) throws UserValidationException;

    List<User> findAll() throws UserValidationException;

    void generateUserFromEmployee(Employee employee) throws UserValidationException, MessagingException;

    void sendPasswordOnEmail(String email) throws UserValidationException, MessagingException;
}
