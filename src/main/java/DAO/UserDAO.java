package DAO;

import entity.User;

import java.util.List;

/**
 * Created by Prigovor on 05.02.2017.
 */
public interface UserDAO {

    Long createEmployee(User user);

    User readEmployee(Long id);

    void updateEmployee(User user);

    void deleteEmployee(Long id);

    List<User> findAll();
}
