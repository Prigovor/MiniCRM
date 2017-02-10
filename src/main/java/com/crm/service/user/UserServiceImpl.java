package com.crm.service.user;

import com.crm.dao.user.UserDAO;
import com.crm.dao.user.UserDAOImpl;
import com.crm.entity.user.User;
import com.crm.service.UserValidationException;

import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class UserServiceImpl implements UserService
{
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public Long createUser(User user) throws UserValidationException
    {
        validateUser();

        return userDAO.createUser(user);
    }

    @Override
    public User readUser(Long id) throws UserValidationException
    {
        validateUser();

        return userDAO.readUser(id);
    }

    @Override
    public void updateUser(User user) throws UserValidationException
    {
        validateUser();

        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) throws UserValidationException
    {
        validateUser();

        userDAO.deleteUser(id);
    }

    @Override
    public List<User> findAll() throws UserValidationException
    {
        validateUser();

        return userDAO.findAll();
    }
}
