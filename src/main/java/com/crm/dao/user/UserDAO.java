package com.crm.dao.user;

import com.crm.entity.user.User;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public interface UserDAO {

    Long createUser(User contact);

    User readUser(Long id);

    void updateUser(User contact);

    void deleteUser(Long id);

    List<User> findAll();
}
