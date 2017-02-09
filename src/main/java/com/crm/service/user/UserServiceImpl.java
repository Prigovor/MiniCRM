package com.crm.service.user;

import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.user.User;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class UserServiceImpl implements UserService
{
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public Long createUser(User user)
    {
        Long id = userDAO.createUser(user);

        return id;
    }

    @Override
    public User readUser(Long id)
    {
        User user = userDAO.readUser(id);

        return user;
    }

    @Override
    public void updateUser(User user)
    {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long id)
    {
        userDAO.deleteUser(id);
    }

    @Override
    public List<User> findAll()
    {
        List<User> listUsers = userDAO.findAll();

        return listUsers;
    }
}
