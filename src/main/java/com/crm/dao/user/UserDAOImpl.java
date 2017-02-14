package com.crm.dao.user;

import com.crm.entity.user.User;
import com.crm.managers.DatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public Long createUser(User user) {
        return DatabaseManager.getInstance().saveEntry(user);
    }

    @Override
    public User readUser(Long id) {
        return DatabaseManager.getInstance().getEntry(id, User.class);
    }

    @Override
    public void updateUser(User user) {
        DatabaseManager.getInstance().updateEntry(user);
    }

    @Override
    public void deleteUser(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, User.class);
    }

    @Override
    public List<User> findAll() {
        return DatabaseManager.getInstance().getEntries(User.class);
    }

    @Override
    public List<User> getUsersByField(String filedName, String fieldValue)
    {
        return DatabaseManager.getInstance().getEntriesByField(filedName, fieldValue, User.class);
    }
}
