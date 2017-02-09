package com.crm.service.user;

import com.crm.entity.user.User;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface UserService
{
    Long createUser(User user);

    User readUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> findAll();
}
