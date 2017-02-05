package DAO;

import entity.User;
import managers.DatabaseManager;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public Long createEmployee(User user) {
        return DatabaseManager.getInstance().saveEntry(user);
    }

    @Override
    public User readEmployee(Long id) {
        return DatabaseManager.getInstance().getEntry(id, User.class);
    }

    @Override
    public void updateEmployee(User user) {
        DatabaseManager.getInstance().updateEntry(user);

    }

    @Override
    public void deleteEmployee(Long id) {
        DatabaseManager.getInstance().deleteEntry(id, User.class);
    }

    @Override
    public List<User> findAll() {
        return DatabaseManager.getInstance().getEntries(User.class);
    }
}
