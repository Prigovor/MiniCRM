package com.crm.service.user;

import com.crm.dao.FactoryDAO;
import com.crm.dao.employee.EmployeeDAO;
import com.crm.dao.user.UserDAO;
import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.managers.EmailManager;
import com.crm.managers.PasswordManager;
import com.crm.service.UserValidationException;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Bohdan on 08.02.2017.
 */
public class UserServiceImpl implements UserService
{
    private UserDAO userDAO = FactoryDAO.getUserDAO();
    private EmployeeDAO employeeDAO = FactoryDAO.getEmployeeDAO();

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

    @Override
    public void generateUserFromEmployee(Employee employee) throws UserValidationException, MessagingException
    {
        validateUser();

        User user = new User();
        user.setLogin(employee.getName().toLowerCase().concat(".").concat(employee.getSurname().toLowerCase()));
        user.setPassword(PasswordManager.getInstance().generatePassword(4));
        user.setEmail(employee.getEmail());
        user.setEmployee(employee);

        int sameUserCount = 0;
        for (User userEntry : userDAO.findAll())
        {
            if (user.getLogin().equals(userEntry.getLogin()))
            {
                sameUserCount++;
            }

            if (user.getPassword().equals(userEntry.getPassword()))
            {
                user.setPassword(PasswordManager.getInstance().generatePassword(4));
            }
        }

        if (sameUserCount != 0)
        {
            user.setLogin(user.getLogin().concat("." + sameUserCount));
        }

        employeeDAO.createEmployee(employee);
        userDAO.createUser(user);

        EmailManager.getInstance().sendMessage(user.getEmail(), "Login and password from MiniSRM account",
                "Login: " + user.getLogin() + "\nPassword: " + user.getPassword());
    }

    @Override
    public void sendPasswordOnEmail(String email) throws UserValidationException, MessagingException
    {

    }
}
